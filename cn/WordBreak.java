package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 139 单词拆分
 * 2025-12-07 13:50:54
 * inwf
 */

public class WordBreak {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            // dp[i]：前 i 个字符（即 s[0..i - 1]）是否可以被字典中的单词拼出来
            // 为什么 dp[i] 不是以 i 结尾的呢？因为如果是空的话就不能判断了，dp[0] 应该表示的是空字符串
            // 遍历每个下标 i，判断 s[i - maxLen, i - 1] 中是否有符合要求的下标，有的话 dp[i] = true

            int maxLen = 0;
            int n = s.length();
            Set<String> set = new HashSet<>();
            for (String word : wordDict) {
                maxLen = Math.max(maxLen, word.length());
                set.add(word);
            }

            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = Math.max(0, i - maxLen); j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        // put your test code here
        // solution.
    }
}