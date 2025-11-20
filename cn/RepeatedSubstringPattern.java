package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 459 重复的子字符串
 * 2025-11-20 17:15:25
 * inwf
 */

public class RepeatedSubstringPattern {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            String ss = s + s;
            int n = ss.length();

            String str = ss.substring(1, n - 1);
            return str.contains(s);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        // put your test code here
        // solution.
    }
}