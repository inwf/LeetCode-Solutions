package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 74 搜索二维矩阵
 * 2025-12-03 12:31:48
 * inwf
 */

public class SearchA2dMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 二分法（只不过下标要换一下）
            // 把二维矩阵拉成一维向量，下标映射：matrix[mid/n,mid%n] == nums[mid]

            int m = matrix.length;
            int n = matrix[0].length;
            int l = 0;
            int r = m * n - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                int i = mid / n;
                int j = mid % n;
                if (matrix[i][j] > target) {
                    r = mid - 1;
                } else if (matrix[i][j] < target) {
                    l = mid + 1;
                } else {
                    return true;
                }
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        // put your test code here
        // solution.
    }
}