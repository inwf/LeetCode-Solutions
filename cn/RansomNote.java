package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 383 赎金信
 * 2025-11-19 17:22:22
 * inwf
 */

public class RansomNote {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] cnt = new int[30];

            for (int i = 0; i < magazine.length(); i++) {
                char c = magazine.charAt(i);
                cnt[c - 'a']++;
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                char c = ransomNote.charAt(i);
                cnt[c - 'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if (cnt[i] < 0) {
                    return false;
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        // put your test code here
        // solution.
    }
}