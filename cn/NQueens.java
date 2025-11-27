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
        List<List<String>> ans = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] chessboard = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chessboard[i][j] = '.';
                }
            }

            dfs(chessboard, n, 0);
            return ans;
        }

        public void dfs(char[][] chessboard, int n, int row) {
            if (row == n) {
                ans.add(Array2List(chessboard));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!check(row, i, n, chessboard)) {
                    continue;
                }

                // 坐标 [row,i] 可以选
                chessboard[row][i] = 'Q';

                // 进入选了 row 行后的 dfs
                dfs(chessboard, n, row + 1);

                // 恢复现场
                chessboard[row][i] = '.';
            }
        }

        public List<String> Array2List(char[][] chessboard) {
            List<String> list = new ArrayList<>();

            for (char[] row : chessboard) {
                list.add(String.valueOf(row));
            }

            return list;
        }


        boolean check(int row, int col, int n, char[][] chessboard) {
            // 因为 dfs 每次选择的都是一行中的某个位置，所以这一行肯定只有一个皇后
            // 判断这一列有没有皇后
            for (int i = 0; i < n; i++) {
                if (chessboard[i][col] == 'Q') {
                    return false;
                }
            }

            // 判断 45° （往右上看）有没有皇后
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }

            // 判断 135° （往左上看）有没有皇后
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        // put your test code here
        // solution.
    }
}