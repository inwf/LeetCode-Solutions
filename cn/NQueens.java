package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 51 N 皇后
 * 2025-11-27 21:49:38
 * inwf
 */

public class NQueens {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 返回所有结果
        List<List<String>> ans = new ArrayList<>();
        char[][] chessBoard;

        public List<List<String>> solveNQueens(int n) {
            chessBoard = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chessBoard[i][j] = '.';
                }
            }

            dfs(n, 0);

            return ans;
        }

        public void dfs(int n, int row) {
            if (row == n) {
                ans.add(array2List(chessBoard));
            }

            // 遍历 row 这一行的所有列
            for (int i = 0; i < n; i++) {
                if (check(row, i, n)) {
                    // 选择 [row,i] 是皇后
                    chessBoard[row][i] = 'Q';

                    // 进入选完后的 dfs
                    dfs(n, row + 1);

                    // 恢复现场
                    chessBoard[row][i] = '.';
                }
            }
        }

        public boolean check(int row, int col, int n) {
            // 这一行不用检查了，因为每个 dfs 都是一行
            // 检查这一列
            for (int i = row - 1; i >= 0; i--) {
                if (chessBoard[i][col] == 'Q') {
                    return false;
                }
            }

            // 检查右上方
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (chessBoard[i][j] == 'Q') {
                    return false;
                }
            }

            // 检查左上方
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessBoard[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }

        public List<String> array2List(char[][] chessBoard) {
            List<String> list = new ArrayList<>();
            for (char[] chars : chessBoard) {
                list.add(new String(chars));
            }

            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        // put your test code here
        // solution.
    }
}