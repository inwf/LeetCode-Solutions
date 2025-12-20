package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 34 在排序数组中查找元素的第一个和最后一个位置
 * 2025-12-03 13:19:04
 * inwf
 */

public class FindFirstAndLastPositionOfElementInSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            // 只用记录找到第一个 >= target 的下标：findLeft(target)
            // end = findLeft(target + 1) - 1
            int start = findLeft(nums, target);
            int end = findLeft(nums, target + 1) - 1;

            if (start == nums.length || nums[start] != target) {
                // 找到这个数
                return new int[]{-1, -1};
            }

            return new int[]{start, end};
        }

        // 二分法找靠左边的： 第一个 nums[mid] >= target 的 mid
        public int findLeft(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            int ans = nums.length;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= target) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            return ans; // 如果没找到返回的是 nums.length
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // put your test code here
        // solution.
    }
}