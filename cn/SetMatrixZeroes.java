package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 73 矩阵置零
 * 2025-11-30 14:08:15
 * inwf
 */

public class SetMatrixZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            // 考虑把数据保存到 matrix 的第一行和第一列中。类似 Excel 表格的第一行和第一列，保存汇总信息
            // 参考灵神
            // 总结：用第一列和第一行表示该列或者该行需不需要全为 0
            // 第一行第一列单独判断
            int m = matrix.length;
            int n = matrix[0].length;
            boolean row = false;
            boolean col = false;

            // 判断第一行有没有 0
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == 0) {
                    row = true;
                    break;
                }
            }
            // 判断第一列有没有 0
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    col = true;
                    break;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            // 把所有有 0 的列置 0
            for (int i = 1; i < n; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 0; j < m; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            // 把所有有 0 的行置 0
            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // 单独判断第一行和第一列
            if (row) {
                for (int i = 0; i < n; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (col) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        // put your test code here
        // solution.
    }
}