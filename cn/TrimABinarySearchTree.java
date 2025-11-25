package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 669 修剪二叉搜索树
 * 2025-11-25 16:56:09
 * inwf
 */

public class TrimABinarySearchTree {

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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            // 递归即可
            // 如果当前节点大于最大值，递归左子树
            // 如果当前节点小于最小值，递归右子树
            // 否则左右都递归

            // 因为根节点也可能被删除，所以在这里直接 return
            return dfs(root, low, high);
//            return root;
        }

        public TreeNode dfs(TreeNode cur, int min, int max) {
            if (cur == null) {
                return null;
            }

            if (cur.val > max) {
                return dfs(cur.left, min, max);
            }

            if (cur.val < min) {
                return dfs(cur.right, min, max);
            }

            // cur 在范围内
            cur.left = dfs(cur.left, min, max);
            cur.right = dfs(cur.right, min, max);
            return cur;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new TrimABinarySearchTree().new Solution();
        // put your test code here
        // solution.
    }
}