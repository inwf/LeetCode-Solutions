package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 5 最长回文子串
 * 2025-12-08 12:32:11
 * inwf
 */

public class LongestPalindromicSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            // 分奇回文串和偶回文串
            // 奇回文串：   abccdccba
            // 偶回文串：   abccddccba
            // 遍历每个回文串的中心，然后往两边扩展

            int ansLeft = 0;
            int ansRight = 0;
            int n = s.length();

            // 奇回文串
            for (int i = 0; i < n; i++) {
                int l = i;
                int r = i;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                // 此时 [l+1,r-1] 是回文串
                if ((r - 1) - (l + 1) > ansRight - ansLeft) {
                    ansLeft = l + 1;
                    ansRight = r - 1;
                }
            }

            // 偶回文串
            for (int i = 0; i < n; i++) {
                int l = i;
                int r = i + 1;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                // 此时 [l+1,r-1] 是回文串
                if ((r - 1) - (l + 1) > ansRight - ansLeft) {
                    ansLeft = l + 1;
                    ansRight = r - 1;
                }
            }

            return s.substring(ansLeft, ansRight + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // put your test code here
        solution.longestPalindrome("a");
    }
}