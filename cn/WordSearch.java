package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 79 单词搜索
 * 2025-12-04 13:51:00
 * inwf
 */

public class WordSearch {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int m;
        int n;

        public boolean exist(char[][] board, String word) {
            // 遍历所有开始，然后 dfs 枚举匹配
            m = board.length;
            n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(0, i, j, board, word)) {
                        return true;
                    }
                }
            }

            return false;
        }

        public boolean dfs(int k, int x, int y, char[][] board, String word) {
            // k 是当前匹配的 word 的下标
            if (word.charAt(k) != board[x][y]) {
                return false;
            }

            // 当前位置匹配：board[x][y] == word[k]
            // k 是下标！！！
            if (k == word.length() - 1) {
                return true;
            }

            // 标记访问过
            board[x][y] = '#';
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (dfs(k + 1, nx, ny, board, word)) {
                        return true;
                    }
                }
            }
            // 恢复现场
            board[x][y] = word.charAt(k);
            // 如果当前位置往哪边走都不匹配的话，就 return false
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        // put your test code here
        // solution.
    }
}