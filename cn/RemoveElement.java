package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 27 移除元素
 * 2025-11-17 18:36:16
 * inwf
 */

public class RemoveElement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            // 快慢指针
            int n = nums.length;
            int slow = 0;
            for (int fast = 0; fast < n; fast++) {
                if (nums[fast] != val){
                    nums[slow] = nums [fast];
                    slow++;
                }
            }

            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // put your test code here
        // solution.
    }
}