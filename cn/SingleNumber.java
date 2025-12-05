package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 136 只出现一次的数字
 * 2025-12-05 14:48:59
 * inwf
 */

public class SingleNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                ans ^= nums[i];
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        // put your test code here
        // solution.
    }
}