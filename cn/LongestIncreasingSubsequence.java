package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 300 最长递增子序列
 * 2025-12-04 20:54:59
 * inwf
 */

public class LongestIncreasingSubsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            // 双重循环
            // dp[i] 表示以 nums[i] 结尾最大长度

            int ans = 0;
            int n = nums.length;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        // put your test code here
        // solution.
    }
}