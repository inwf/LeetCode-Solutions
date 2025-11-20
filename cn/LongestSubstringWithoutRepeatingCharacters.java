package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 3 无重复字符的最长子串
 * 2025-11-20 20:38:34
 * inwf
 */

public class LongestSubstringWithoutRepeatingCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int l = 0;
            int r = 0;
            int n = s.length();
            int ans = 0;
            Set<Character> set = new HashSet<>();

            for (r = 0; r < n; r++) {
                char c = s.charAt(r);

                if (set.contains(c)) {
                    while (set.contains(c)) {
                        // 直到不包含 r 位置的字符
                        char temp = s.charAt(l);
                        set.remove(temp);
                        l++;
                    }
                }

                set.add(c);
                ans = Math.max(ans, r - l + 1);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here
        solution.lengthOfLongestSubstring("abcabcbb");
    }
}