package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 701 二叉搜索树中的插入操作
 * 2025-11-25 12:46:16
 * inwf
 */

public class InsertIntoABinarySearchTree {

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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            // 不用考虑左旋或者右旋（因为没说要平衡）
            // 插入后自己是叶子节点即可
            if (root == null) {
                return new TreeNode(val);
            }


            dfs2(root, val);
            return root;
        }

        public TreeNode dfs(TreeNode cur, int val) {
            // 插到这即可
            if (cur == null) {
                return new TreeNode(val);
            }

            if (val < cur.val) {
                // 往左边找
                cur.left = dfs(cur.left, val);
            } else {
                // 往右边找
                cur.right = dfs(cur.right, val);
            }

            return cur;
        }

        public void dfs2(TreeNode cur, int val) {

            // 找到了
            if (val < cur.val && cur.left == null) {
                cur.left = new TreeNode(val);
                return;
            } else if (val > cur.val && cur.right == null) {
                cur.right = new TreeNode(val);
                return;
            }

            if (val < cur.val) {
                // 往左边找
                dfs2(cur.left, val);
            } else {
                // 往右边找
                dfs2(cur.right, val);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
        // put your test code here
        // solution.
    }
}