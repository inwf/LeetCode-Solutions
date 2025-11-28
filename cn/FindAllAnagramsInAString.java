package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 438 找到字符串中所有字母异位词
 * 2025-11-28 21:33:03
 * inwf
 */

public class FindAllAnagramsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        List<Integer> ans = new ArrayList<>();

        public List<Integer> findAnagrams(String s, String p) {
            // 滑动窗口
            int l = 0;
            for (int i = 0; i < p.length(); i++) {
                cnt1[p.charAt(i) - 'a']++;
            }


            for (int r = 0; r < s.length(); r++) {
                cnt2[s.charAt(r) - 'a']++;

                if (r - l + 1 > p.length()) {
                    cnt2[s.charAt(l) - 'a']--;
                    l++;
                }

                // check() 只有长度相等的时候才可能 return true
                if (check()) {
                    ans.add(l);
                }
            }


            return ans;
        }

        boolean check() {
            for (int i = 0; i < 26; i++) {
                if (cnt1[i] != cnt2[i]) {
                    return false;
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // put your test code here
        // solution.
    }
}