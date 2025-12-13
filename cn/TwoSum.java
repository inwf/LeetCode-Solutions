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
            // 哈希表
            Map<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target-nums[i]),i};
                }

                // 存{值，下标}
                map.put(nums[i],i);
            }

            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here
//        solution.twoSum(   );
    }
}