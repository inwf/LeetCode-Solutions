package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 240 搜索二维矩阵 II
 * 2025-11-30 16:48:54
 * inwf
 */

public class SearchA2dMatrixIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 对每一行进行二分法
            // 找不到就返回 false
            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
                // 对每一行进行二分法
                // 左闭右闭
                int l = 0;
                int r = n - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (matrix[i][mid] > target) {
                        r = mid - 1;
                    } else if (matrix[i][mid] < target) {
                        l = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        // put your test code here
        // solution.
    }
}