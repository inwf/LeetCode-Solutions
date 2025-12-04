package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 198 打家劫舍
 * 2025-12-04 20:47:53
 * inwf
 */

public class HouseRobber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            // 做到肌肉记忆即可
            // dp[i] 表示到第 i（包括 i ） 个的最大值
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }

            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        // put your test code here
        // solution.
    }
}