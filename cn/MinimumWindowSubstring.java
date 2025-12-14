package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

import javax.sql.rowset.spi.TransactionalWriter;

/**
 * 76 最小覆盖子串
 * 2025-11-29 12:12:39
 * inwf
 */

public class MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            // 存储大小写字母，所以用 128
            int[] need = new int[128];
            int count = t.length();
            for (int i = 0; i < count; i++) {
                need[t.charAt(i)]++;
            }

            int l = 0;
            int r = 0;
            int n = s.length();
            int ansLeft = -1;
            int ansRight = s.length(); // 越大越好

            for (r = 0; r < n; r++) {
                char c = s.charAt(r);

                if (need[c] > 0) {
                    count--;
                }
                need[c]--;

                while (count == 0) {
                    // 此时符合要求
                    if (r - l < ansRight - ansLeft) {
                        ansLeft = l;
                        ansRight = r;
                    }

                    c = s.charAt(l);
                    if (need[c] == 0) {
                        // 此时是 0，就不能进到下一轮了
                        // 因为后面会 l++
                        count++;
                    }

                    need[c]++;
                    l++;
                }
            }
            return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // put your test code here
        solution.minWindow("cbda", "a");
    }
}