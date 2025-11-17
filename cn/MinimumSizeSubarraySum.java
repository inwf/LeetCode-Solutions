package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 209 长度最小的子数组
 * 2025-11-17 21:21:49
 * inwf
 */

public class MinimumSizeSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int l = 0;
            int n = nums.length;
            int sum = 0;

            for (int r = 0; r < n; r++) {
                sum += nums[r];
                while (sum >= target) {
                    ans = Math.min(ans, r - l + 1);
                    sum -= nums[l];
                    l++;
                }
            }

            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        // put your test code here
        // solution.
    }
}