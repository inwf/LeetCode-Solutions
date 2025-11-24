package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 700 二叉搜索树中的搜索
 * 2025-11-24 16:23:00
 * inwf
 */

public class SearchInABinarySearchTree {

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
        public TreeNode searchBST(TreeNode root, int val) {
            // 二叉搜索树（BST）：如果找到叶子节点还没找到的话，说明不存在
            TreeNode ans = dfs(root, val);
            return ans;
        }

        public TreeNode dfs(TreeNode cur, int val) {
            if (cur == null) {
                return null;
            }

            if (val > cur.val) {
                return dfs(cur.right, val);
            } else if (val < cur.val) {
                return dfs(cur.left, val);
            } else {
                return cur;
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();
        // put your test code here
        // solution.
    }
}