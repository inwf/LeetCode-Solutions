package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 1 两数之和
 * 2025-11-17 15:18:52
 * inwf
 */

public class TwoSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] ans = new int[2];

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    ans[0] = map.get(target - nums[i]);
                    ans[1] = i;
                    break;
                } else {
                    map.put(nums[i], i);
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here
//        solution.twoSum(   );
    }
}