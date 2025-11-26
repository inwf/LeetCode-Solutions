package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 39 组合总和
 * 2025-11-26 19:03:46
 * inwf
 */

public class CombinationSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates, target, 0, 0);
            return ans;
        }

        public void dfs(int[] nums, int target, int sum, int startIndex) {
            if (sum > target) {
                return;
            }

            if (sum == target) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                // 选择 nums[i]
                path.add(nums[i]);
                sum += nums[i];

                // 进入选择 nums[i] 后的 dfs
                dfs(nums, target, sum, i);

                // 恢复现场
                sum -= nums[i];
                path.remove(path.size() - 1);
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        // put your test code here
        // solution.
    }
}