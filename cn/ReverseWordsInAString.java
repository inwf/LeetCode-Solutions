package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 151 反转字符串中的单词
 * 2025-11-20 16:43:19
 * inwf
 */

public class ReverseWordsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int n = s.length();
            char[] c = s.toCharArray();
            char[] ans = new char[n + 1];
            int idx = 0;

            for (int i = n - 1; i >= 0; i--) {
                while (i >= 0 && c[i] == ' ') {
                    i--;
                }
                int r = i;

                while (i >= 0 && c[i] != ' ') {
                    i--;
                }
                int l = i;

                // 左闭右闭
                for (int j = l + 1; j <= r; j++) {
                    ans[idx++] = c[j];
                    if (j == r) {
                        ans[idx++] = ' ';
                    }
                }
                // 不能写在这，不然最后可能会多一个空字符""，然后就多了一个空格
//                ans[idx++] = ' ';
            }

            return new String(ans, 0, idx - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        // put your test code here
        solution.reverseWords("  hello world  ");
    }
}