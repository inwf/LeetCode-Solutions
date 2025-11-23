package leetcode.editor.cn;

import leetcode.editor.common.*;

/**
 * 404 左叶子之和
 * 2025-11-23 16:21:28
 * inwf
 */

public class SumOfLeftLeaves {

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
        private int ans = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            // 递归:后续遍历
            // 当前节点作为根的时候,左叶子之和 = 左子树左叶子之和 + 右子树左叶子之和
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode cur) {
            if (cur == null) {
                return;
            }

            dfs(cur.left);
            dfs(cur.right);

            if (cur.left != null && cur.left.left == null && cur.left.right == null) {
                ans += cur.left.val;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
        // put your test code here
        // solution.
    }
}