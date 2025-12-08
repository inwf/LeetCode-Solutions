package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 763 划分字母区间
 * 2025-12-08 23:44:21
 * inwf
 */

public class PartitionLabels {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            // 就是区间合并

            List<Integer> ans = new ArrayList<>();
            int[] last = new int[26];
            int n = s.length();
            for (int i = 0; i < n; i++) {
                last[s.charAt(i) - 'a'] = Math.max(last[s.charAt(i) - 'a'], i);
            }

            int end = 0;
            int start = 0;
            for (int i = 0; i < n; i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);

                if (end == i) {
                    ans.add(end - start + 1);
                    start = i + 1; // 下一个区间的起点
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
        // put your test code here
        // solution.
    }
}