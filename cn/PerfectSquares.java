package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 279 完全平方数
 * 2025-12-06 23:48:41
 * inwf
 */

public class PerfectSquares {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            // dp[i] 表示和恰好为 i 的最少个数
            int[] dp = new int[n + 1];

            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 1; i * i <= n; i++) {
                // 当前数是 i*i （第 i 个数是 i*i）
                int x = i * i;
                for (int j = x; j <= n; j++) {
                    dp[j] = Math.min(dp[j],dp[j-x] + 1);
                }
            }

            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        // put your test code here
        // solution.
    }
}