package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 40 组合总和 II
 * 2025-11-26 19:12:27
 * inwf
 */

public class CombinationSumIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // DFS + 剪枝
            // 去重思路：同一层上两个相同元素不能重复选
            Arrays.sort(candidates);
            dfs(candidates, target, 0, 0);
            return ans;
        }

        public void dfs(int[] nums, int target, int sum, int startIndex) {
            if (sum == target) {
                ans.add(new ArrayList<>(path));
            }

            if (sum > target) {
                return;
            }

            if (startIndex == nums.length) {
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                // 去重：同一层不能选相同的元素
                // 同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
                // 同一层一个值只用第一个，后面的都 continue
                if (i > startIndex && nums[i] == nums[i - 1]) {
                    continue;
                }

                // 选择 nums[i]
                path.add(nums[i]);
                sum += nums[i];

                // 进入选择 nums[i] 后的 dfs
                dfs(nums, target, sum, i + 1);

                sum -= nums[i];
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        // put your test code here
        // solution.
    }
}