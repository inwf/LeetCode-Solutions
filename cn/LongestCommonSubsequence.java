package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 1143 最长公共子序列
 * 2025-12-08 12:59:07
 * inwf
 */

public class LongestCommonSubsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            // dp[i][j] 表示 text1[0,i-1] 和 text2[0,j-1] 的最长公共子序列的长度

            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 这样可以确保每个点都遍历到
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[m][n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        // put your test code here
        // solution.
    }
}