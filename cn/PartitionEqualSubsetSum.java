package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 416 分割等和子集
 * 2025-12-06 12:15:27
 * inwf
 */

public class PartitionEqualSubsetSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            // 要等分的话，和一定是偶数，否则直接返回 false
            // 假设和为 s，那么找到和为 s/2 的子序列即可
            /**
             * 现在积累的一个大概思路：
             * 如果是子序列，就考虑使用01背包。
             * 如果是连续子序列的，就考虑前后累加。
             * 这个思路待以后刷题数量增加而丰富
             */

            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }

            if (sum % 2 == 1) {
                // 和为奇数
                return false;
            }

            // 和为偶数
            sum /= 2;
            // dp[i] 表示体积为 i 的最大价值
            int[] dp = new int[sum + 1];
            for (int i = 0; i < n; i++) {
                for (int j = sum; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
                }
            }

            return dp[sum] == sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        // put your test code here
        // solution.
    }
}