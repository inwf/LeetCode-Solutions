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
            // 双指针
            // 当前窗口内字符不重复

            int l = 0;
            int r = 0;
            int n = s.length();
            int ans = 0;
            Set<Character> set = new HashSet<>();
            for (r = 0; r < n; r++) {
                char c = s.charAt(r);

                // 当前 r 的下标是窗口右边界
                while (set.contains(c)) {
                    // 注意移除的字符是 s.charAt(l)
                    set.remove(s.charAt(l));
                    l++;
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