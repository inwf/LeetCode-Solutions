package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 18 四数之和
 * 2025-11-19 22:22:37
 * inwf
 */

public class FourSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            // 三数之和进阶版
            // 排序 + 双指针 + 剪枝 + 去重等操作

            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                if (nums[i] > target && nums[i] > 0) {
                    break;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = i + 1; j < n; j++) {
                    if (nums[i] + nums[j] > target && nums[j] > 0) {
                        break;
                    }

                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int l = j + 1;
                    int r = n - 1;
                    int sum;
                    while (l < r) {
                        sum = nums[i] + nums[j] + nums[l] + nums[r];

                        if (sum > target) {
                            r--;
                        } else if (sum < target) {
                            l++;
                        } else {
                            ans.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) l++;
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            l++;
                            r--;
                        }
                    }
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        // put your test code here
        // solution.
    }
}