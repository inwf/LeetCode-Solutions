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
        // 注意这里是 long
        private long pre = Long.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            // 按照二叉搜索树的性质来判断
            // 左子树节点值小于当前节点、右子树节点值大于当前节点
            // 就是中序遍历单调递增
            // 对于每个节点，判断当前节点是否满足二叉搜索树

            return dfs(root);
        }

        public boolean dfs(TreeNode cur) {
            if (cur == null) {
                return true;
            }

            // 左 -> 中 -> 右
            boolean left = dfs(cur.left);
            if (!left) {
                return false;
            }

            if (pre >= cur.val) {
                return false;
            }
            pre = cur.val;

            boolean right = dfs(cur.right);
            if (!right) {
                return false;
            }

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