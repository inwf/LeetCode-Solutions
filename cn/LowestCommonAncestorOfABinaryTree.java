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
            // 对于每个当前节点，返回左边或者右边的查找结果，没找到就返回 null
            // 因为是最近，所以找到了不是返回本身，而是返回找到的那个左\右子节点
            return dfs(root, p, q);
        }

        public TreeNode dfs(TreeNode cur, TreeNode p, TreeNode q) {
            if (cur == null || cur == p || cur == q) {
                // 找到了直接返回，找不到就返回 null
                return cur;
            }

            TreeNode left = dfs(cur.left, p, q);
            TreeNode right = dfs(cur.right, p, q);

            // 如果当前节点就是答案（左右都找到了），就返回自己
            if (left != null && right != null) {
                return cur;
            }

            if (left == null && right == null) {
                // 左右都没找到
                return null;
            } else if (left != null) {
                // 左边找到了
                return left;
            } else {
                // 右边找到了
                return right;
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