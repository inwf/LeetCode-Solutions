package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 112 路径总和
 * 2025-11-23 18:24:35
 * inwf
 */

public class PathSum {

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            // DFS 遍历
            // 判断当前节点能否满足条件:
            // 1 当前节点是叶子节点: 累计的路径长度 = targetSum
            // 2 当前节点不是叶子节点: 左子树或者右子树其中一个可以满足条件
            return dfs(root, 0, targetSum);
        }

        public boolean dfs(TreeNode cur, int path, int targetSum) {
            if (cur == null) {
                return false;
            }

            // 路径加上当前节点
            path += cur.val;

            // 当前节点是叶子节点
            if (cur.left == null && cur.right == null) {
                return path == targetSum;
            }

            // 当前节点不是叶子节点
            return dfs(cur.left, path, targetSum) || dfs(cur.right, path, targetSum);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
        // put your test code here
        // solution.
    }
}