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
            // 要先排序
            // 双指针 + 剪枝 + 去重
            // 去重：同一个数只遍历第一个
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    // 去重：相同数字只遍历第一个
                    continue;
                }

                int l = i + 1;
                int r = n - 1;

                while (l < r) {

                    int sum = nums[i] + nums[l] + nums[r];

                    if (sum > 0) {
                        r--;
                    } else if (sum < 0) {
                        l++;
                    } else {
                        ans.add(List.of(nums[i],nums[l],nums[r]));
                        l++;
                        r--;
                        // 注意去重时机：这里先 l++，r-- 是小巧思
                        // 相同数字计算完第一个后再去重，所以要在 if 后去重
                        // 跳过重复元素：1 2 2 2 2 3，要把最左边的 2 移到最右边的 2 然后再 + 1
                        while(l<r && nums[l] == nums[l-1]) l++;
                        while(l<r && nums[r] == nums[r+1]) r--;
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