package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 437 路径总和 III
 * 2025-12-02 15:33:22
 * inwf
 */

public class PathSumIii {

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
        Map<Long, Integer> cnt = new HashMap<>(); // 记录路径和为 i 的有 j 个（cnt[i] = j）
        int ans = 0;

        public int pathSum(TreeNode root, int targetSum) {
            // 参考灵神
            // 枚举路径的终点，统计有多少个起点
            // 树上前缀和，需要遍历所有节点（dfs）
            cnt.put(0L, 1); // 注意范围，路径和可能很大
            dfs(root, targetSum, 0L);
            return ans;
        }

        public void dfs(TreeNode cur, int targetSum, Long sum) {
            if (cur == null) {
                return;
            }

            sum += cur.val;
            ans += cnt.getOrDefault(sum - targetSum, 0);
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);

            // 选择进入后续节点
            dfs(cur.left, targetSum, sum);
            dfs(cur.right, targetSum, sum);

            // 回溯（恢复现场，但是 sum 是局部变量不用恢复，但是 cnt 需要回溯）
            cnt.put(sum, cnt.get(sum) - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        // put your test code here
        // solution.
    }
}