package leetcode.editor.cn;

import java.util.*;

/**
 * 994 腐烂的橘子
 * 2025-12-11 13:55:44
 * inwf
 */

public class RottingOranges {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 新鲜橘子个数，因为如果不能全腐烂返回 -1，所以要记录 cnt
        int cnt = 0;
        int ans = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        public int orangesRotting(int[][] grid) {
            // 类似于层序遍历，有 x 层答案就是 x - 1( 如果没有新的就不算这一层了 )：BFS
            // 每次遍历新加的腐烂的橘子

            Deque<int[]> queue = new LinkedList<>();
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        cnt++;
                    }
                }
            }

            bfs(grid, queue);
            return cnt == 0 ? ans : -1;
        }

        public void bfs(int[][] grid, Deque<int[]> queue) {
            int m = grid.length;
            int n = grid[0].length;

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean hasNew = false;

                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];

                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                            grid[nx][ny] = 2;
                            queue.offer(new int[]{nx, ny});
                            hasNew = true;
                            cnt--;
                        }
                    }
                }

                if (hasNew) {
                    ans++;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
        // put your test code here
        // solution.
    }
}