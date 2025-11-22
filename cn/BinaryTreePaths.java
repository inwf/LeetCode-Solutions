package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 257 二叉树的所有路径
 * 2025-11-22 23:35:13
 * inwf
 */

public class BinaryTreePaths {

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
        public List<String> binaryTreePaths(TreeNode root) {
            // 就是 DFS 进阶一下
            List<String> ans = new LinkedList<>();
            dfs(root, "", ans);
            return ans;
        }

        public void dfs(TreeNode cur, String path, List<String> ans) {
            if (cur == null) {
                return;
            }

            path += cur.val;
            if (cur.left == null && cur.right == null) {
                // 当前节点是叶子节点，返回即可
                ans.add(path);
            }

            // 当前节点还有子节点
            path += "->";
            if (cur.left != null) {
                dfs(cur.left, path, ans);
            }
            if (cur.right != null) {
                dfs(cur.right, path, ans);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        // put your test code here
        // solution.
    }
}