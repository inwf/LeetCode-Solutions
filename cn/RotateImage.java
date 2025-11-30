package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 48 旋转图像
 * 2025-11-30 16:43:06
 * inwf
 */

public class RotateImage {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            // 本质：转置 + 行翻转
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            for (int i = 0; i < n; i++) {
                int l = 0;
                int r = n - 1;
                while (l < r) {
                    int temp = matrix[i][l];
                    matrix[i][l] = matrix[i][r];
                    matrix[i][r] = temp;
                    l++;
                    r--;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        // put your test code here
        // solution.
    }
}