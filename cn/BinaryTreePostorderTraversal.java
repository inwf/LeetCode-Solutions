package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 145 二叉树的后序遍历
 * 2025-11-21 20:08:00
 * inwf
 */

public class BinaryTreePostorderTraversal {

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
        public List<Integer> postorderTraversal(TreeNode root) {
            // 后序遍历（根在后）：左 -> 右 -> 中
            List<Integer> ans = new ArrayList<>();

            order(root, ans);
            return ans;
        }

        public void order(TreeNode cur, List<Integer> ans) {
            if (cur == null) {
                return;
            }

            order(cur.left,ans);
            order(cur.right,ans);
            ans.add(cur.val);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        // put your test code here
        // solution.
    }
}