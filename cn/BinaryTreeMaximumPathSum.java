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

            // 0 是可以不选左节点：这里写的很妙
            int left = Math.max(0, dfs(cur.left));
            int right = Math.max(0, dfs(cur.right));

            ans = Math.max(ans, cur.val + left + right);
            return cur.val + Math.max(left, right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        // put your test code here
        // solution.
    }
}