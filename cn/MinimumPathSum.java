package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 64 最小路径和
 * 2025-12-08 11:05:57
 * inwf
 */

public class MinimumPathSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            // 每次只能向右或者向左
            // dp[i][j] 表示到 [i,j] 的最小路径和
            // 类比 62.不同路径

            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];

            // 初始化列、初始化行
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }

            return dp[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        // put your test code here
        // solution.
    }
}