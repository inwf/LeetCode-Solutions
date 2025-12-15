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
            // 从左上角开始，第一行第一列单独判断
            boolean row = false;
            boolean col = false;
            int m = matrix.length;
            int n = matrix[0].length;

            // 第一行
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == 0) {
                    row = true;
                }
            }

            // 第一列
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    col = true;
                }
            }

            // 开始遍历，然后标记到第一行和第一列
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            // 开始根据标记行染色
            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // 开始根据标记列染色
            for (int i = 1; i < n; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 0; j < m; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }

            // 第一行需要染色
            if (row) {
                for (int i = 0; i < n; i++) {
                    matrix[0][i] = 0;
                }
            }

            // 第一列需要染色
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