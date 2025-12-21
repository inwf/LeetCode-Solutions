package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 121 买卖股票的最佳时机
 * 2025-12-08 20:07:00
 * inwf
 */

public class BestTimeToBuyAndSellStock {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            // 找出当前时间之前的最小值再计算一下就行
            // 就是遍历在哪一天卖出

            int ans = 0;
            int min = prices[0];
            int n = prices.length;
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, prices[i] - min);
                min = Math.min(min, prices[i]);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        // put your test code here
        // solution.
    }
}