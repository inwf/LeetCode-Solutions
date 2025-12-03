package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 153 寻找旋转排序数组中的最小值
 * 2025-12-03 23:35:42
 * inwf
 */

public class FindMinimumInRotatedSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            /**只需要比较 nums[mid] 和 nums[n−1] 的大小关系
             * 就间接地知道了 nums[mid] 和数组最小值的位置关系
             */

            int l = 0;
            int r = nums.length - 1;
            int end = nums[r];
            int ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > end) {
                    // nums[mid] 在第一段
                    // 最小值在当前右边
                    l = mid + 1;
                } else {
                    // nums[mid] <= end
                    // 要么当前是答案，要么答案在左边
                    ans = nums[mid];
                    r = mid - 1;
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        // put your test code here
        // solution.
    }
}