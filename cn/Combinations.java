package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 77 组合
 * 2025-11-25 23:43:28
 * inwf
 */

public class Combinations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            // 组合：就是不降序列
            dfs(n, k, 1);
            return ans;
        }

        public void dfs(int n, int k, int startIndex) {
            if (path.size() == k) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i <= n; i++) {
                // 1 选择 i
                path.add(i);

                // 2 进入选择 i 后的 dfs
                dfs(n, k, i + 1);

                // 3 退出选择 i 的 dfs 了（恢复现场）
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        // put your test code here
        // solution.
    }
}