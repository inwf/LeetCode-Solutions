package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 62 不同路径
 * 2025-12-07 23:47:38
 * inwf
 */

public class UniquePaths {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            // dp[i][j] 表示到 [i,j] 的路径数
            int[][] dp = new int[m][n];

            // 初始化列
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }

            // 初始化行
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        // put your test code here
        // solution.
    }
}