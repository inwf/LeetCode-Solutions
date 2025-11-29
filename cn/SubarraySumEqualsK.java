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
            int n = nums.length;
            int ans = 0;

            // 前缀和，sum[i] 表示 nums[0] + ... + nums[i-1] 之和
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }

            //  cnt[i] 表示和为 i 的个数
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < sum.length; i++) {
                ans += cnt.getOrDefault(sum[i] - k, 0);
                // 为什么先 ans+ 再 put？
                // 因为判断的是 sum[i] 前面有几个和为 sum[i] - k 的子数组
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