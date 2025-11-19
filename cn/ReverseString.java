package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 344 反转字符串
 * 2025-11-19 23:03:56
 * inwf
 */

public class ReverseString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int n = s.length;
            int l = 0;
            int r = n - 1;
            while (l < r) {
                char temp = s[l];
                s[l] = s[r];
                s[r] = temp;
                l++;
                r--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        // put your test code here
        // solution.
    }
}