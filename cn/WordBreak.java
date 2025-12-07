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
            int maxLen = 0;
            for (String x : wordDict) {
                maxLen = Math.max(maxLen, x.length());
            }

            Set<String> set = new HashSet<>(wordDict);
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;

            // 枚举前缀长度 i：表示我们要判断 s[0..i - 1] 能不能拆分
            for (int i = 1; i <= n; i++) {
                // j 代表最后一段的开始下标
                for (int j = Math.max(i - maxLen, 0); j < i; j++) {
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