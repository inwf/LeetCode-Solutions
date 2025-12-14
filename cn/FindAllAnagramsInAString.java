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
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        List<Integer> ans = new ArrayList<>();

        public List<Integer> findAnagrams(String s, String p) {
            // 双指针滑动窗口
            // 当两个桶数组相同的时候就判定两者是异位词
            for (int i = 0; i < p.length(); i++) {
                cntP[p.charAt(i) - 'a']++;
            }

            // 双指针 + 滑动窗口
            int l = 0;
            int r = 0;
            for (r = 0; r < s.length(); r++) {
                char c = s.charAt(r);
                cntS[c - 'a']++;

                if (r - l + 1 > p.length()) {
                    cntS[s.charAt(l) - 'a']--;
                    l++;
                }

                // 只有长度相等的时候才进行判断
                if (check()) {
                    ans.add(l);
                }
            }
            return ans;
        }

        boolean check() {
            for (int i = 0; i < 26; i++) {
                if (cntS[i] != cntP[i]) {
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
