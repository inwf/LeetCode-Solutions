package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 283 移动零
 * 2025-12-13 21:03:09
 * inwf
 */

public class MoveZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            // 双指针
            // 就是把不等于 0 的移到前面（下标 i ）去
            int n = nums.length;
            for(int i = 0, j = 0;j<n;j++){
                if (nums[j] != 0){
                    swap(nums,i,j);
                    i++;
                }
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here
        // solution.
    }
}