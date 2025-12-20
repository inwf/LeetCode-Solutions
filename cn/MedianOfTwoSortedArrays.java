package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 4 寻找两个正序数组的中位数
 * 2025-12-12 13:06:08
 * inwf
 */

public class MedianOfTwoSortedArrays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int len = m + n;
            if (m > n) {
                return findMedianSortedArrays(nums2, nums1);
            }

            // l,r 是左边在 nums1 的个数
            int l = 0;
            int r = m;
            while (l <= r) {
                int i = l + (r - l) / 2;
                int j = (len + 1) / 2 - i;

                int aLeft = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
                int aRight = i == m ? Integer.MAX_VALUE : nums1[i];
                int bLeft = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
                int bRight = j == n ? Integer.MAX_VALUE : nums2[j];

                int leftMax = Math.max(aLeft, bLeft);
                int rightMin = Math.min(aRight, bRight);

                if (leftMax <= rightMin) {
                    // 找到了
                    if (len % 2 == 1) {
                        return leftMax;
                    } else {
                        return (leftMax + rightMin) / 2.0;
                    }
                } else if (aLeft > bRight) {
                    r = i - 1;
                } else {
                    l = i + 1;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // put your test code here
        // solution.
    }
}