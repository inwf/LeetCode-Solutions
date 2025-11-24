package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 530 二叉搜索树的最小绝对差
 * 2025-11-24 20:54:58
 * inwf
 */

public class MinimumAbsoluteDifferenceInBst {

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
        int ans = Integer.MAX_VALUE;
        int pre = Integer.MIN_VALUE / 2; // 防止溢出

        public int getMinimumDifference(TreeNode root) {
            // 因为是二叉搜索树，所以中序遍历（左 -> 中 -> 右）
            // 二叉搜索树中序遍历是递增的
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode cur) {
            if (cur == null) {
                return;
            }

            dfs(cur.left); // 左

            ans = Math.min(ans, (cur.val - pre)); // 中
            pre = cur.val;

            dfs(cur.right); // 右
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
        // put your test code here
        // solution.
    }
}