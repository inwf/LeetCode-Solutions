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

            if (start != nums.length && nums[start] == target) {
                // 找到了结果
                return new int[]{start, end};
            }

            // 注意这种 return 写法
            return new int[]{-1, -1};
        }

        // 找到第一个 >= target 的元素下标，返回 nums.length 表示没找到
        public int findLeft(int[] nums, int target) {
            int ans = nums.length;
            int l = 0;
            int r = nums.length - 1;
            // 左闭右闭
            // 没找到就返回 -1
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= target) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // put your test code here
        // solution.
    }
}