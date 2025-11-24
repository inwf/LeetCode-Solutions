package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 236 二叉树的最近公共祖先
 * 2025-11-24 21:28:56
 * inwf
 */

public class LowestCommonAncestorOfABinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // dfs 后序遍历：当前节点如果是 p 或 q，则返回当前节点
            // 否则返回自己节点的左右子节点能找到的节点（都找到就返回自己）
            return dfs(root, p, q);
        }

        public TreeNode dfs(TreeNode cur, TreeNode p, TreeNode q) {
            if (cur == null || cur == p || cur == q) {
                // 当前为 null 或者本身就是 p 或 q，就返回自己
                return cur;
            }

            TreeNode left = dfs(cur.left, p, q); // 从左子节点找
            TreeNode right = dfs(cur.right, p, q); // 从右子节点找

            // 1 如果当前节点就是答案，直接返回
            if (left != null && right != null) {
                return cur;
            }

            // 2 否则 return 当前节点的查找结果（找到就返回对应的，否则是 null）
            if (left == null && right == null) {
                return null;
            } else if (left == null) {
                // 右边找到了
                return right;
            } else {
                // 左边找到了（right == null）
                return left;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        // put your test code here
        // solution.
    }
}