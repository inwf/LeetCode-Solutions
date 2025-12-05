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
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (hp == 0){
                    ans = nums[i];
                    hp = 1;
                }else if (ans == nums[i]){
                    hp ++;
                }else {
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