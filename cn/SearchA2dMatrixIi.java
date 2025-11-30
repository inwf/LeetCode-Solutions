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
            // 法1：遍历行，然后每行做二分法
            // 法2：灵神的比较右上角法：https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/2783938/tu-jie-pai-chu-fa-yi-tu-miao-dong-python-kytg/?envType=study-plan-v2&envId=top-100-liked

            // 二分
            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
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