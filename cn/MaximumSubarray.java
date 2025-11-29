package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 53 最大子数组和
 * 2025-11-29 16:41:05
 * inwf
 */

public class MaximumSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            // 简单 dp
            int n = nums.length;
            // dp[i] 表示以 nums[i] 结尾的子数组的最大和
            int[] dp = new int[n];
            dp[0] = nums[0];
            int ans = nums[0];

            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                ans = Math.max(ans, dp[i]);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        // put your test code here
        // solution.
    }
}