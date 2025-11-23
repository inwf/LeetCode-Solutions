package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 100 相同的树
 * 2025-11-23 13:56:24
 * inwf
 */

public class SameTree {

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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 用递归
            // 只有两种情况，要么都为 null
            // 要么都不为 null 且 当前节点及其左右子节点相等

            if (p == null && q == null) {
                return true;
            }

            if (p != null && q != null && p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
        // put your test code here
        // solution.
    }
}