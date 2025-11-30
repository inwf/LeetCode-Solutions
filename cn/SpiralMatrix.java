package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 54 螺旋矩阵
 * 2025-11-30 16:29:41
 * inwf
 */

public class SpiralMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            // 模拟题
            List<Integer> ans = new ArrayList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            // 从 [0,0] 开始
            int i = 0;
            int j = 0;
            int idx = 0;
            // 一个 m * n 个元素
            for (int cnt = 0; cnt < m * n; cnt++) {
                ans.add(matrix[i][j]);

                // 表示这个点被遍历过了
                matrix[i][j] = Integer.MAX_VALUE;

                int nx = i + dx[idx];
                int ny = j + dy[idx];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == Integer.MAX_VALUE) {
                    idx = (idx + 1) % 4;
                }

                i = i + dx[idx];
                j = j + dy[idx];
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // put your test code here
        // solution.
    }
}