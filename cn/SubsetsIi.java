package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 90 子集 II
 * 2025-11-27 15:58:47
 * inwf
 */

public class SubsetsIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // 和组合总和II 很像
            // DFS + 同层不选相同的元素（就选第一个即可）
            Arrays.sort(nums);
            dfs(nums, 0);
            return ans;
        }

        public void dfs(int[] nums, int startIndex) {
            // 选的是所有子集，所以把树上每个节点都 add 进去
            ans.add(new ArrayList<>(path));

            if (startIndex == nums.length) {
                // 记得 return
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                // 同一层相同元素只选第一个
                if (i > startIndex && nums[i] == nums[i - 1]) {
                    continue;
                }

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
        Solution solution = new SubsetsIi().new Solution();
        // put your test code here
        // solution.
    }
}