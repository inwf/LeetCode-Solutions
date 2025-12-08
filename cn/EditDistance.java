package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 72 编辑距离
 * 2025-12-08 18:08:44
 * inwf
 */

public class EditDistance {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            // 删除、（插入可以忽略，因为插入一个等价于删除另一个）、替换
            // dp[i][j] 表示 word1[0,i-1] 和 word2[j,j-1] 的最小答案

            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];

            // 初始化第一行和第一列（要初始化所有情况）
            for (int i = 0; i <= n; i++) {
                dp[0][i] = i;
            }

            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 替换、删除、删除
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }

            return dp[m][n];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        // put your test code here
        // solution.
    }
}