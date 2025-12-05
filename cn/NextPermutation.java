package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 31 下一个排列
 * 2025-12-05 14:19:43
 * inwf
 */

public class NextPermutation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            // 参考：https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/?envType=study-plan-v2&envId=top-100-liked
            int n = nums.length;

            int i;
            for (i = n - 2; i >= 0; i--) {
                // 从右往找到第一个 nums[i] < nums[i+1] 的位置
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }

            // 找到了，从右往左找第一个大于 nums[i] 的元素
            if (i >= 0) {
                int j = n - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }

                // swap(nums,i,j);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            // 将 nums[i] 之后的元素改为递增
            reverse(nums, i + 1, n - 1);
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
        Solution solution = new NextPermutation().new Solution();
        // put your test code here
        // solution.
    }
}