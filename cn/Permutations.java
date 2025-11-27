package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 46 全排列
 * 2025-11-27 16:25:48
 * inwf
 */

public class Permutations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // 用于判断这个下标的元素是否被用过
        boolean[] used = new boolean[30];

        public List<List<Integer>> permute(int[] nums) {
            // 可以没有，只是为了和答案一样
            Arrays.sort(nums);
            dfs(nums);
            return ans;
        }

        public void dfs(int[] nums) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                // 选择 nums[i]
                used[i] = true;
                path.add(nums[i]);

                // 进入选完 nums[i] 后的 dfs
                dfs(nums);

                // 恢复现场
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // put your test code here
        // solution.
    }
}