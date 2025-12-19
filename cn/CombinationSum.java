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

        public void dfs(int[] candidates, int target, int sum, int startIndex) {
            if (sum > target) {
                return;
            }

            if (sum == target) {
                ans.add(new ArrayList<>(path));
                return;
            }

            int n = candidates.length;
            for (int i = startIndex; i < n; i++) {
                // 选择某个数
                sum += candidates[i];
                path.add(candidates[i]);

                // 进入选完这个数后的 dfs，可以重复选，所以传入的是 i 不是 i + 1
                dfs(candidates, target, sum, i);

                // 恢复现场
                sum -= candidates[i];
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