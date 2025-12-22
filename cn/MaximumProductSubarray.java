package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 152 乘积最大子数组
 * 2025-12-04 20:58:54
 * inwf
 */

public class MaximumProductSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            // dp[i] 表示 nums[i] 结尾的最大乘积

            int n = nums.length;
            // 本次乘积最大可能在下次变成乘积最小
            int[] dpMax = new int[n];
            int[] dpMin = new int[n];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            int ans = nums[0];
            for (int i = 1; i < n; i++) {
                int x = nums[i];
                // 乘与不乘
                dpMax[i] = Math.max(x,(Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i])));
                dpMin[i] = Math.min(x,(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i])));
                ans = Math.max(ans,(Math.max(dpMax[i], dpMin[i])));
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        // put your test code here
        // solution.
    }
}