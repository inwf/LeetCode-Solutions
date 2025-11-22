package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 107 二叉树的层序遍历 II
 * 2025-11-22 12:13:13
 * inwf
 */

public class BinaryTreeLevelOrderTraversalIi {

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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // 层序遍历 + 反转 即可

            List<List<Integer>> ans = new ArrayList<>();
            bfs(root, ans);
            Collections.reverse(ans);
            return ans;
        }

        public void bfs(TreeNode root, List<List<Integer>> ans) {
            if (root == null) {
                return;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                int n = queue.size();
                List<Integer> temp = new ArrayList<>(n);

                // 一口气把这一层全遍历完，把下一层全加入队列
                for (int i = 0; i < n; i++) {
                    TreeNode now = queue.poll();

                    if (now.left != null) {
                        queue.offer(now.left);
                    }
                    if (now.right != null) {
                        queue.offer(now.right);
                    }
                    temp.add(now.val);
                }

                ans.add(temp);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        // put your test code here
        // solution.
    }
}