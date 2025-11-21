package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 144 二叉树的前序遍历
 * 2025-11-21 19:57:44
 * inwf
 */

public class BinaryTreePreorderTraversal {

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
        public List<Integer> preorderTraversal(TreeNode root) {
            // 前序遍历（根在前）：中 -> 左 -> 右
            // 三要素（从上往下）：
            // 1 确定递归函数的参数和返回值
            // 2 确定终止条件
            // 3 确定单层递归的逻辑

            List<Integer> ans = new ArrayList<>();
            order(root, ans);

            return ans;
        }

        public void order(TreeNode cur, List<Integer> ans) {
            if (cur == null) {
                return;
            }
            ans.add(cur.val);
            order(cur.left, ans);
            order(cur.right, ans);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        // put your test code here
        // solution.
    }
}