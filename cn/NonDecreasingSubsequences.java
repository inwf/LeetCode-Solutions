package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 491 非递减子序列
 * 2025-11-27 16:09:44
 * inwf
 */

public class NonDecreasingSubsequences {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            // 每个节点判断一下元素个数 > 2
            // 这题还不能拍下吧，因为他要找的是子序列，数字相对顺序要和原数组一样
            // 所以用和集合 set 来判断这一层有没有重复元素即可
            // DFS + 同一层不能重复元素
            dfs(nums, 0);
            return ans;
        }

        public void dfs(int[] nums, int startIndex) {
            // 每一个节点（元素个数 > 2）都 add
            if (path.size() >= 2) {
                ans.add(new ArrayList<>(path));
            }

            if (startIndex == nums.length) {
                return;
            }

            Set<Integer> set = new HashSet<>();
            for (int i = startIndex; i < nums.length; i++) {
                // 每一层相同值的元素只选第一个
                if (set.contains(nums[i])){
                    continue;
                }

                // 不降才会进入下一层
                if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                    continue;
                }

                // 选择 nums[i]
                path.add(nums[i]);

                // 进入选完 nums[i] 后的 dfs
                dfs(nums, i + 1);

                // 恢复现场
                path.remove(path.size() - 1);

                // 表示这一层的 nums[i] 已经被选过了
                set.add(nums[i]);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new NonDecreasingSubsequences().new Solution();
        // put your test code here
        // solution.
    }
}