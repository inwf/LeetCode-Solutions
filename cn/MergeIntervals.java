package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 56 合并区间
 * 2025-11-29 16:50:52
 * inwf
 */

public class MergeIntervals {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 先排序，然后模拟题

            int n = intervals.length;
            List<int[]> ans = new ArrayList<>();
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            for (int i = 0; i < n; i++) {
                int[] cur = intervals[i];

                if (i == 0) {
                    ans.add(cur);
                    continue;
                }

                int[] pre = ans.get(ans.size() - 1);
                if (pre[1] >= cur[0]) {
                    pre[1] = Math.max(pre[1], cur[1]);
                } else {
                    ans.add(cur);
                }
            }

            return ans.toArray(new int[ans.size()][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // put your test code here
        // solution.
    }
}