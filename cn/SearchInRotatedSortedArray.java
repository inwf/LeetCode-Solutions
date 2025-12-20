package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 33 搜索旋转排序数组
 * 2025-12-03 14:24:53
 * inwf
 */

public class SearchInRotatedSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            // 这里有序性比较难看：
            // 某个数 x 如果 > nums[-1]，说明在第一段
            // 某个数 x 如果 <= nums[-1]，说明在第二段

            int l = 0;
            int r = nums.length - 1;
            int end = nums[r];
//            int ans = -1; // 如果没找到，返回 -1

            while (l <= r) {
                int mid = l + (r - l) / 2;

                // 分三类

                if (nums[mid] <= end && target > end) {
                    // nums[mid] 在第二段，target 在第一段
                    r = mid - 1;
                } else if (nums[mid] > end && target <= end) {
                    // nums[mid] 在第一段，target 在第二段
                    l = mid + 1;
                } else {
                    // nums[mid] 和 target 在同一段，直接比大小即可
                    if (nums[mid] > target) {
                        r = mid - 1;
                    } else if (nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        // put your test code here
        // solution.
    }
}