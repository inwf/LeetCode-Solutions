package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 114 二叉树展开为链表
 * 2025-12-02 15:25:20
 * inwf
 */

public class FlattenBinaryTreeToLinkedList {

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
        TreeNode head; // 就是结果链表的头节点

        public void flatten(TreeNode root) {
            // 就是先序遍历的顺序，但是先序遍历会导致右节点数据丢失（从上往下）
            // 所以可以按照 右 -> 左 -> 中 的顺序，从下往上，用头插法
            dfs(root);
        }

        public void dfs(TreeNode cur) {
            if (cur == null) {
                return;
            }

            dfs(cur.right);
            dfs(cur.left);
            cur.right = head;
            cur.left = null;
            head = cur;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        // put your test code here
        // solution.
    }
}