package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 128 最长连续序列
 * 2025-12-13 20:54:22
 * inwf
 */

public class LongestConsecutiveSequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            // set 去重
            Set<Integer> set = new HashSet<>();
            // 如果 nums 为空，返回 0
            int ans = 0;

            for (int i : nums) {
                set.add(i);
            }

            for (int x : set) {
                int cnt = 1;
                if (set.contains(x - 1)) {
                    // 因为连续序列只要从刚开始计数就够了
                    // 所以这里可以剪枝
                    continue;
                }

                int y = x + 1;
                while (set.contains(y)) {
                    y++;
                    cnt++;
                }

                ans = Math.max(ans, cnt);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        // put your test code here
        // solution.
    }
}