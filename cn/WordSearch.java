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
        int m = 0;
        int n = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

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

        public boolean dfs(int idx, int x, int y, char[][] board, String word) {
            // idx 是当前 word 的下标
            if (board[x][y] != word.charAt(idx)) {
                return false;
            }

            // 这里 [x,y] 已经匹配了 word[idx]
            if (idx == word.length() - 1) {
                return true;
            }

            // 标记这个点已经走过了
            board[x][y] = '#';

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (dfs(idx + 1, nx, ny, board, word)) {
                    return true;
                }
            }

            // 恢复现场
            board[x][y] = word.charAt(idx);

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