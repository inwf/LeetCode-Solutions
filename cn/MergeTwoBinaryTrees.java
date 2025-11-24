package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 617 合并二叉树
 * 2025-11-24 12:23:28
 * inwf
 */

public class MergeTwoBinaryTrees {

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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            // 用dfs遍历即可，每次当前节点合并就是：当前 val 相加&&左子节点合并&&右子节点合并
            if (root1 == null) {
                return root2;
            }

            dfs(root1, root2);
            return root1;
        }

        public TreeNode dfs(TreeNode cur1, TreeNode cur2) {
            // 有一个是 null 就变成另外一个，两个都是 null 就变成 null
            if (cur1 == null) {
                return cur2;
            }
            if (cur2 == null) {
                return cur1;
            }

            // 合并当前节点
            cur1.left = dfs(cur1.left, cur2.left);
            cur1.right = dfs(cur1.right, cur2.right);
            cur1.val += cur2.val;
            return cur1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
        // put your test code here
        // solution.
    }
}