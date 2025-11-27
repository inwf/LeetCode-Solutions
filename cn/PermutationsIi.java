package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 47 全排列 II
 * 2025-11-27 21:19:52
 * inwf
 */

public class PermutationsIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[10];

        public List<List<Integer>> permuteUnique(int[] nums) {
            // DFS + 同一层只能有一个相同元素
            // 就是同一层相同元素只选第一个
            dfs(nums);
            return ans;
        }

        public void dfs(int[] nums) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                // 同一层一样的元素只取第一个
                if (set.contains(nums[i])) {
                    continue;
                }

                // 下标为 i 的元素已经被选过了
                if (used[i]) {
                    continue;
                }

                // 选择 nums[i]
                used[i] = true;
                path.add(nums[i]);

                // 进入选完 nums[i] 后的 dfs
                dfs(nums);

                // 恢复现场
                path.remove(path.size() - 1);
                used[i] = false;

                set.add(nums[i]);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        // put your test code here
        // solution.
    }
}