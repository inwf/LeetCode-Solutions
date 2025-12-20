package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 35 搜索插入位置
 * 2025-12-03 12:19:19
 * inwf
 */

public class SearchInsertPosition {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            // 典型二分
            // 找到第一个 nums[mid] >= target 元素的下标

            int l = 0;
            int r = nums.length - 1;
            int ans = nums.length; // 没找到就返回数组长度，这里的初始化不是随便来的！

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
        Solution solution = new SearchInsertPosition().new Solution();
        // put your test code here
        // solution.
    }
}