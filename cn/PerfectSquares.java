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
            // dp[i] 表示和为 i 的最小平方数的数量
            // 恰好装满问题：dp[0] = 0
            // 其余最小就初始化为 MAX_VALUE，最大就初始化为 MIN_VALUIE

            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i * i <= n; i++) {
                // 第 i 个数是 i * i
                int x = i * i;
                for (int j = x; j <= n; j++) {
                    dp[j] = Math.min(dp[j - x] + 1, dp[j]); // 选和不选
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