package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 199 二叉树的右视图
 * 2025-11-22 13:20:47
 * inwf
 */

public class BinaryTreeRightSideView {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            // 就是层序遍历，然后只存最后边的元素即可
            List<Integer> ans = new ArrayList<>();
            bfs(root, ans);
            return ans;
        }

        public void bfs(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int n = queue.size();

                // 一口气把这一层全 poll() 把下一层全 offer()
                for (int i = 0; i < n; i++) {
                    TreeNode now = queue.poll();

                    if (now.left != null) {
                        queue.offer(now.left);
                    }
                    if (now.right != null) {
                        queue.offer(now.right);
                    }

                    if (i == n - 1) {
                        // 只存最右边
                        ans.add(now.val);
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        // put your test code here
        // solution.
    }
}