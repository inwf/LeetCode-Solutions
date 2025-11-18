package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 242 有效的字母异位词
 * 2025-11-18 21:36:57
 * inwf
 */

public class ValidAnagram {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] map = new int[30];
            if (s.length() != t.length()) {
                return false;
            }
            int n = s.length();

            for (int i = 0; i < n; i++) {
                map[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < n; i++) {
                map[t.charAt(i) - 'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if(map[i]!=0){
                    return false;
                }
            }

            return true;

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        // put your test code here
        // solution.
    }
}