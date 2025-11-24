package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 113 路径总和 II
 * 2025-11-23 18:34:22
 * inwf
 */

public class PathSumIi {

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

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            // DFS + 存路径的节点
            // 1 当前节点是叶子节点: 判断是否符合条件
            // 2 当前节点不是叶子节点: 继续遍历
            List<List<Integer>> ans = new ArrayList<>();

            // 维护一个路径节点列表
            List<Integer> path = new ArrayList<>();

            dfs(root, 0, targetSum, path, ans);
            return ans;
        }

        public void dfs(TreeNode cur, int sum, int targetSum, List<Integer> path, List<List<Integer>> ans) {
            if (cur == null) {
                return;
            }

            // 路径之和加上当前节点
            sum += cur.val;
            path.add(cur.val);

            // 1 当前节点是叶子节点
            if (cur.left == null && cur.right == null) {
                if (sum == targetSum) {
                    // 必须 new 一个,不然存的是同一个引用
                    ans.add(new ArrayList<>(path));
                }
            }

            // 2 当前节点不是叶子节点
            dfs(cur.left, sum, targetSum, path, ans);
            dfs(cur.right, sum, targetSum, path, ans);

            // 2.1 遍历完当前节点了,要回溯到上级,恢复现场
            path.remove(path.size() - 1);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        // put your test code here
        // solution.
    }
}