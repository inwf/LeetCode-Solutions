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
        // 128 是为了存所有大小写字母（ASCII码）
        int[] need = new int[128];

        public String minWindow(String s, String t) {
            int count = t.length();
            for (int i = 0; i < count; i++) {
                need[t.charAt(i)]++;
            }

            int ansLeft = -1;
            int ansRight = s.length();
            int l = 0;
            for (int r = 0; r < s.length(); r++) {
                char c = s.charAt(r);
                if (need[c] > 0) {
                    count--;
                }
                // 这里 need[c] 放到外面，才能在后面need[l] == 0的时候说明是从 > 0 变为 0 的，（要不然是复数）
                need[c]--;

                while (count == 0) {
                    // 目前的 l 和 r 是符合的
                    if (r - l < ansRight - ansLeft) {
                        ansLeft = l;
                        ansRight = r;
                    }

                    c = s.charAt(l);
                    // 这里只有当 t 中出现的字母才有可能从 0 变成 > 0（下面 ++ 后变成 >0）
                    // 否则只在 s 中出现的字母这里最大才是 -1，然后下面 ++ 变成 0
                    if (need[c] == 0) {
                        // 左边不能再缩了
                        count++;
                    }

                    // 左边窗口往右边移动
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