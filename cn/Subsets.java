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
            // 比常规递归简单
            // 子集问题会收集所有节点的结果
            // 所以不需要判断是否到叶子节点，直接收集答案即可
            dfs(nums, 0);
            return ans;
        }

        public void dfs(int[] nums, int startIndex) {
            ans.add(new ArrayList<>(path));

            if (startIndex == nums.length) {
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                // 选 nums [i]
                path.add(nums[i]);

                // 进入选完 nums[i] 后的 dfs
                dfs(nums, i + 1);

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