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
            // 层序遍历，只保留最后一层最后一个节点即可
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

                for (int i = 0; i < n; i++) {
                    TreeNode cur = queue.poll();

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }

                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }

                    if (i == n - 1) {
                        // 最后一个元素
                        ans.add(cur.val);
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