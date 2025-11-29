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
            // 模拟题
            // 先排序（左端点排序）
            // 然后遍历模拟即可：前一个节点的右端点 >= 当前节点的左端点，就合并
            // 排序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int n = intervals.length;
            List<int[]> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int[] cur = intervals[i];
                if (i == 0) {
                    ans.add(cur);
                } else {
                    int[] last = ans.get(ans.size() - 1);
                    if (last[1] >= cur[0]) {
                        // 可以合并（数组是引用类型）
                        last[1] = Math.max(last[1], cur[1]);
//                        ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], cur[1]);
                    } else {
                        // 不能合并
                        ans.add(cur);
                    }
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