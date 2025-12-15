package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 41 缺失的第一个正数
 * 2025-11-29 20:38:58
 * inwf
 */

public class FirstMissingPositive {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 换座位
            // 参考：https://leetcode.cn/problems/first-missing-positive/solutions/3655377/huan-zuo-wei-tong-guo-li-zi-li-jie-suan-qa94e/?envType=study-plan-v2&envId=top-100-liked
            // 如果当前元素值为 x，那么 x 应该在下标为 x - 1 的位置
            // nums[i] == nums[nums[i] - 1]

            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // for 循环一轮后，nums 中每个数字都到了自己应该在的位置
                while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                    int j = nums[i] - 1;
                    swap(nums, i, j);
                }
            }

            for (int i = 0; i < n; i++) {
                // 这里已经换好座位了，所以直接判断
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            return n + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        // put your test code here
        // solution.
    }
}