package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 189 轮转数组
 * 2025-11-29 17:02:56
 * inwf
 */

public class RotateArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            // 1 全体翻转
            // 2 翻转 [0,k}
            // 3 翻转 [k,n-1]
            // 注意：k 要取模
            int n = nums.length;
            k = k % n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        public void reverse(int[] nums, int l, int r) {
            while (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        // put your test code here
        // solution.
    }
}