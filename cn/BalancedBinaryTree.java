package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 110 平衡二叉树
 * 2025-11-22 20:35:44
 * inwf
 */

public class BalancedBinaryTree {

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
        public boolean isBalanced(TreeNode root) {
            // 平衡二叉树：任意一个节点的左右子树的高度差 <= 1
            // 用递归方法
            // 当前节点高度 = max(左子树高度，右子树高度) + 1 或者 0（左右子树都是 null）
            // 不能用最大深度和最小深度的差是否小于 1 来判断
            /**反例如下：根节点左右子树高度：2，0
             *          x
             *        /
             *      x
             *    /
             *  x
             *
             */

            // 后续遍历回溯

            return height(root) != -1;
        }

        public int height(TreeNode cur) {
            if (cur == null) {
                return 0;
            }

            TreeNode l = cur.left;
            TreeNode r = cur.right;
            int lHeight = height(l);
            if (lHeight == -1) {
                return -1;
            }
            int rHeight = height(r);
            if (rHeight == -1) {
                return -1;
            }

            if (Math.abs(lHeight - rHeight) > 1) {
                return -1;
            }

            return Math.max(lHeight, rHeight) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        // put your test code here
        // solution.
    }
}