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
            // 完全背包问题：左 -> 右
            // 恰好装满：初始化 dp[0] = 0，其他 MAX_VALUE

            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            dp[0] = 0;
            int n = coins.length;
            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]); // 选 vx 不选
                }
            }

            return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        // put your test code here
        // solution.
    }
}