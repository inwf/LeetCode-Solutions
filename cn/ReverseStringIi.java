package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 541 反转字符串 II
 * 2025-11-20 12:40:43
 * inwf
 */

public class ReverseStringIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            // 转字符数组
            char[] c = s.toCharArray();
            int n = s.length();

            for (int i = 0; i < n; i += 2 * k) {
                int l = i;
                int r = Math.min(l + k - 1, n - 1);
                while (l < r) {
                    char temp = c[l];
                    c[l] = c[r];
                    c[r] = temp;
                    l++;
                    r--;
                }
            }
            return new String(c);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        // put your test code here
        // solution.
    }
}