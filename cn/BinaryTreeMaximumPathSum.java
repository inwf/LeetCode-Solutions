package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 124 二叉树中的最大路径和
 * 2025-12-02 23:39:15
 * inwf
 */

public class BinaryTreeMaximumPathSum {

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
        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            // 就是最大直径的魔改题
            // DFS 遍历
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode cur) {
            if (cur == null) {
                return 0;
            }

            // 找出左子节点的最大路径
            int l = dfs(cur.left);

            // 找出右子节点的最大路径
            int r = dfs(cur.right);

            // 当前节点最大路径 = 当前节点
            // 或者当前节点加左子节点最大路径
            // 或者当前节点加右子节点最大路径
            ans = Math.max(ans, Math.max(cur.val, cur.val + l + r));

            // 为什么和 0 比？如果都是负数的话，那一个节点都不选，他上层节点就是 = 上层节点加这层（返回的 0）
            return Math.max(0, cur.val + Math.max(l, r));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        // put your test code here
        // solution.
    }
}