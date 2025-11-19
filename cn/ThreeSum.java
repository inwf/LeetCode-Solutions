package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 15 三数之和
 * 2025-11-19 17:26:08
 * inwf
 */

public class ThreeSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 排序 + 双指针 + 剪枝 + 去重等操作
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    break;
                }

                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    // 如果和前面的一样的话，就 + 1
                    // 因为这个数已经判断过了
                    continue;
                }

                // 固定左边
                int l = i + 1;
                int r = n - 1;
                // 双指针
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];

                    if (sum > 0) {
                        r--;
                    } else if (sum < 0) {
                        l++;
                    } else {
                        ans.add(List.of(nums[i], nums[l], nums[r]));

                        // 去重操作：
                        //（1 2 2 2 3）从最左边的 2 移到最右边的 2
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;

                        // 关键
                        l++;
                        r--;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // put your test code here
//        solution.threeSum(new int[]{-2, -2, -2, 0, 1, 2, 2, 2, 4, 4, 4});
    }
}