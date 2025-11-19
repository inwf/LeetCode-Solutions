package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 454 四数相加 II
 * 2025-11-19 17:10:20
 * inwf
 */

public class FourSumIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            // 要记录一下个数（sum 的和可能相同）
            Map<Integer, Integer> map = new HashMap<>();
            int cnt = 0;
            int sum;

            for (int i : nums1) {
                for (int j : nums2) {
                    sum = i + j;
                    map.put((sum), map.getOrDefault((sum), 0) + 1);
                }
            }

            for (int i : nums3) {
                for (int j : nums4) {
                    sum = i + j;
                    if (map.containsKey(-(sum))) {
                        cnt += map.get(-(sum));
                    }
                }
            }

            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        // put your test code here
        // solution.
    }
}