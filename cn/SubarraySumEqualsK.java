package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 560 和为 K 的子数组
 * 2025-11-28 21:47:52
 * inwf
 */

public class SubarraySumEqualsK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 子数组是连续的

            int ans = 0;
            int n = nums.length;
            // s[i] 表示 nums[0,i - 1] 之和
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }

            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < sum.length; i++) {
                ans += cnt.getOrDefault(sum[i] - k, 0);
                // 因为是非空的，所以必须先算 ans 再把 sum[0] put 进去
                // 反例： nums = {1}，k = 0
                cnt.put(sum[i], cnt.getOrDefault(sum[i], 0) + 1);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        // put your test code here
        solution.subarraySum(new int[]{1, 1, 1}, 2);
    }
}