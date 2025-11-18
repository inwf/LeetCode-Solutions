package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 1002 查找共用字符
 * 2025-11-18 21:51:11
 * inwf
 */

public class FindCommonCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] words) {
            // https://programmercarl.com/1002.%E6%9F%A5%E6%89%BE%E5%B8%B8%E7%94%A8%E5%AD%97%E7%AC%A6.html#%E6%80%9D%E8%B7%AF

            int[] map = new int[30];
            for (int i = 0; i < words[0].length(); i++) {
                map[words[0].charAt(i) - 'a']++;
            }

            for (int i = 1; i < words.length; i++) {
                int[] temp = new int[30];

                for (int j = 0; j < words[i].length(); j++) {
                    temp[words[i].charAt(j) - 'a']++;
                }

                for (int j = 0; j < 26; j++) {
                    map[j] = Math.min(map[j], temp[j]);
                }
            }

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                while (map[i] != 0) {
                    map[i]--;
                    char c = (char) ('a' + i);
                    ans.add(String.valueOf(c));
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        // put your test code here
        // solution.
    }
}