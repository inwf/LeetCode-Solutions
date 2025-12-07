package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 322 零钱兑换
 * 2025-12-07 11:58:40
 * inwf
 */

public class CoinChange {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // 完全背包问题 -> 从左往右
            // 恰好装满问题 -> 初始化为 MAX_VALUE

            // dp[i] 表示金额为 i 的最少硬币数
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE/2);
            dp[0] = 0;
            int n = coins.length;
            for (int i = 0; i < n; i++) {
                // 至少能装一个，所以 j 从 coins[i] 开始遍历
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1); // 不装/装
                }
            }

            return dp[amount] == Integer.MAX_VALUE/2? -1:dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        // put your test code here
        // solution.
    }
}