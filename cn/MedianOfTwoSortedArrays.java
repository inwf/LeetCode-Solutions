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
            // hard
            // 参考：https://www.bilibili.com/video/BV1H5411c7oC/
            // 用递归选长度小的数，逼格高一点
            // 时间复杂度 O(min(m,n))
            // a:   第一段 i 第二段
            // b:  第一段 j 第二段
            // i 和 j 指向第二段的开始下标

            int m = nums1.length;
            int n = nums2.length;
            if (m > n) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int len = m + n;
            // 闭区间：第二段开始下标范围是 [0,m]（第一段全在 b 和第一段全在 a）
            int left = 0;
            int right = m;
            while (left <= right) {
                // i 表示 a 的第二段开始下标
                // j 表示 b 的第二段开始下标
                int i = left + (right - left) / 2;
                // 因为如果是奇数的话，返回值是左边最大值
                // 所以这里要 (len + 1)：9 个元素的话，返回第五个，所以左边要有 5 个元素
                int j = (len + 1) / 2 - i;

                // 下面的 xLeft 和 xRight 表示 x 数组的第一段结尾 和 第二段开始
                // Left 找最大值，Right 找最小值
                // 因为要找的是左边最大值，所以如果 i == 0 的话表示第一段全在 b 中，所以这里直接负无穷即可
                int aLeft = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
                // 这里是找第二段在 a 的开始下标，如果第二段全在 b 的话，那就找第二段在 b 的最小值即可，所以赋值正无穷
                int aRight = i == m ? Integer.MAX_VALUE : nums1[i];
                int bLeft = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
                int bRight = j == n ? Integer.MAX_VALUE : nums2[j];

                int maxLeft = Math.max(aLeft, bLeft);
                int minRight = Math.min(aRight, bRight);

                if (maxLeft <= minRight) {
                    // 符合要求，返回（这里二刷的时候可以想一想，和前面 a 数组是长度比较小的结合起来）
                    if (len % 2 == 0) {
                        return (maxLeft + minRight) / 2.0;
                    } else {
                        return maxLeft;
                    }
                } else if (aLeft > bRight) {
                    // 现在的 i 太靠右了，导致第一段在 a 的部分偏多
                    right = i - 1;
                } else {
                    left = i + 1;
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // put your test code here
        // solution.
    }
}