package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 215 数组中的第K个最大元素
 * 2025-12-09 12:24:59
 * inwf
 */

public class KthLargestElementInAnArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 桶排序，因为有负数，所以映射到下标的时候 + 1e4 即可

            int[] cnt = new int[20001];
            int n = nums.length;
            int temp = 10000;
            for (int i = 0; i < n; i++) {
                // 计数，下标 - temp 就是元素的值
                cnt[nums[i] + temp]++;
            }

            for (int i = 20000; i >= 0; i--) {
                // 有元素就减，没有就减 0
                k = k - cnt[i];

                if (k <= 0) {
                    return i - temp;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // put your test code here
        // solution.
    }
}