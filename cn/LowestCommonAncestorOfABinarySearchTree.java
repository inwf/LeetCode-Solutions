package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 235 二叉搜索树的最近公共祖先
 * 2025-11-24 23:46:35
 * inwf
 */

public class LowestCommonAncestorOfABinarySearchTree {

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
            // 从上往下找（前序遍历）
            // 第一个 cur.val 在 p,q 值以内的节点就是最近公共祖先
            // https://www.programmercarl.com/0235.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
            if (p.val < q.val) {
                return dfs(root, p.val, q.val);
            } else {
                return dfs(root, q.val, p.val);
            }
        }

        public TreeNode dfs(TreeNode cur, int min, int max) {
            if (cur == null) {
                return null;
            }

            if (min < cur.val && cur.val < max) {
                return cur;
            }

            // 答案在左边
            if (cur.val > max) {
                return dfs(cur.left, min, max);
            }

            // 答案在右边
            if (cur.val < min) {
                return dfs(cur.right, min, max);
            }

            // 如果访问到 cur = p 或 q 的时候，直接返回自己
            return cur;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
        // put your test code here
        // solution.
    }
}