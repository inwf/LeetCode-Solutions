package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 98 验证二叉搜索树
 * 2025-11-24 16:30:48
 * inwf
 */

public class ValidateBinarySearchTree {

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
        private long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            // 按照二叉搜索树的性质来判断
            // 左子树节点值小于当前节点
            // 右子树节点值大于当前节点
            // 对于每个节点，判断当前节点是否满足二叉搜索树

            return dfs(root);
        }

        public boolean dfs(TreeNode cur) {
            // 因为是二叉搜索树，所以用中序遍历（左 -> 中 -> 右），节点值是递增的！
            if (cur == null) {
                return true;
            }

            boolean left = dfs(cur.left); // 左
            if (!left) {
                // 左子树不符合
                return false;
            }

            if (cur.val <= pre) { // 中
                // 当前节点不符合
                return false;
            }
            pre = cur.val;

            boolean right = dfs(cur.right); // 右
            if (!right) {
                // 右子树不符合
                return false;
            }

            // 都符合
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        // put your test code here
        // solution.
    }
}