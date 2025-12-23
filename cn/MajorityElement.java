package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 169 多数元素
 * 2025-12-05 14:50:01
 * inwf
 */

public class MajorityElement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int ans = nums[0];
            int hp = 0;
            for (int num : nums) {
                if (hp == 0) {
                    ans = num;
                    hp = 1;
                } else if (ans == num) {
                    hp++;
                } else {
                    hp--;
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        // put your test code here
        // solution.
    }
}