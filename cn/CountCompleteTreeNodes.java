package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 222 完全二叉树的节点个数
 * 2025-11-22 20:15:24
 * inwf
 */

public class CountCompleteTreeNodes {

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
        public int countNodes(TreeNode root) {
            // 可以直接遍历，但是体现不出完全二叉树的性质了
            // 这题用递归

            if (root == null) {
                return 0;
            }

            TreeNode l = root.left;
            TreeNode r = root.right;
            // 左子树高度
            int lDepth = 0;
            // 右子树高度
            int rDepth = 0;

            while (l != null) {
                lDepth++;
                l = l.left;
            }
            while (r != null) {
                rDepth++;
                r = r.right;
            }

            if (lDepth == rDepth) {
                // 这里其实是左子树高度，加上根节点实际上是 lDepth + 1，所以后面直接 2^(lDepth + 1) - 1 了
                // 总会遍历到左右子树高度相等的时候
                // 极端情况：当前是叶子节点，左右子树都是 null，高度都是0
                // 注意(1<<1) 相当于2^1，lDepth 初始为 0，还要加上当前节点
                return (1 << lDepth + 1) - 1; // 完全二叉树节点个数：2^n -1
            } else {
                // 当前节点个数(1) + 左子树节点个数 + 右子树节点个数
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        // put your test code here
        // solution.
    }
}