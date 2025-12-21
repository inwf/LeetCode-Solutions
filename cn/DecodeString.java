package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 394 字符串解码
 * 2025-12-09 12:40:54
 * inwf
 */

public class DecodeString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 注意：这个 i 必须是全局变量
        int i = 0;

        public String decodeString(String s) {
            // 递归，从左往右遍历
            // 遇到数字就记录一下
            // 遇到 [ 就递归，遇到 ] 就退出递归

            return dfs(s);
        }

        public String dfs(String s) {
            StringBuilder str = new StringBuilder();
            int n = s.length();
            int k = 0; // 用来记录数字

            while (i < n) {
                char c = s.charAt(i);
                i++;
                if (c >= '0' && c <= '9') {
                    // 是数字
                    k = k * 10 + (c - '0');
                } else if (c >= 'a' && c <= 'z') {
                    // 是字母：正常接在后面
                    str.append(c);
                } else if (c == '[') {
                    String temp = dfs(s);
                    str.append(temp.repeat(k));
                    k = 0;
                } else {
                    // c == ']'
                    break;
                }
            }

            return str.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        // put your test code here
        // solution.
    }
}