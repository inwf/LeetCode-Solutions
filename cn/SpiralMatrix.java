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
            // 模拟题，标记走过的位置
            // 走到不能走了就换方向
            List<Integer> ans = new ArrayList<>();
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int m = matrix.length;
            int n = matrix[0].length;

            int idx = 0;
            int x = 0;
            int y = 0;
            for (int i = 0; i < m * n; i++) {
                ans.add(matrix[x][y]);
                matrix[x][y] = Integer.MAX_VALUE;

                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == Integer.MAX_VALUE) {
                    idx = (idx + 1) % 4;
                }

                x = x + dx[idx];
                y = y + dy[idx];
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