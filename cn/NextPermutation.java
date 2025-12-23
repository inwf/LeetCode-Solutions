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
            // 如果找不到,就返回升序（找不到的情况是原始就是倒序，reverse 即可）
            int n = nums.length;

            // 先找出第一个递增的位置
            int i = 0;
            for (i = n - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }

            if (i >= 0) {
                // 找到了
                // 继续找最小的比 nums[i] 大的数，然后调换
                int j = n - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }

                // 此时 nums[j] 是 nums[i] 右边最小的 > nums[i] 的数
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            // 最后将 i 后面改成递增即可
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