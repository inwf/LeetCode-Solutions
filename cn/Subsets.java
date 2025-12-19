package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 78 子集
 * 2025-11-27 12:54:15
 * inwf
 */

public class Subsets {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            // 无序：取过的元素不会重复取，写回溯算法的时候，for 就要从 startIndex 开始
            // 子集问题会收集所有节点的结果
            // 所以不需要判断是否到叶子节点，直接收集答案即可
            dfs(nums, 0);
            return ans;
        }

        public void dfs(int[] nums, int startIndex) {
            // 每一次进 dfs 都 add
            ans.add(new ArrayList<>(path));

            if (startIndex >= nums.length) {
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                // 选择 nums[i]
                path.add(nums[i]);

                // 进入选完 nums[i] 后的 dfs
                dfs(nums, i + 1);

                // 恢复现场
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        // put your test code here
        // solution.
    }
}