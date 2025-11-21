package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 94 二叉树的中序遍历
 * 2025-11-21 20:08:03
 * inwf
 */

public class BinaryTreeInorderTraversal {

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
        public List<Integer> inorderTraversal(TreeNode root) {
            // 中序遍历（根在中）：左 -> 中 -> 右
            List<Integer> ans = new ArrayList<>();
            order(root, ans);
            return ans;
        }

        public void order(TreeNode cur, List<Integer> ans) {
            if (cur == null) {
                return;
            }

            order(cur.left, ans);
            ans.add(cur.val);
            order(cur.right, ans);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        // put your test code here
        // solution.
    }
}