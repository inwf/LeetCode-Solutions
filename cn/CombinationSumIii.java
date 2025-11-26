package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 216 组合总和 III
 * 2025-11-26 15:02:45
 * inwf
 */

public class CombinationSumIii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            // DFS + 减枝
            dfs(k, n, 1, 0);
            return ans;
        }

        public void dfs(int k, int n, int startIndex, int sum) {
            if (sum > n) {
                return;
            }

            if (path.size() == k) {
                if (sum == n) {
                    ans.add(new ArrayList<>(path));
                    return;
                }
            }

            for (int i = startIndex; i <= 9; i++) {
                // 选 i
                path.add(i);
                sum += i;

                dfs(k, n, i + 1, sum);

                // 恢复现场
                path.remove(path.size() - 1);
                sum -= i;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        // put your test code here
        // solution.
    }
}