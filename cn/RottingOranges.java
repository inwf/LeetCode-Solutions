package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 994 腐烂的橘子
 * 2025-12-11 13:55:44
 * inwf
 */

public class RottingOranges {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 新鲜橘子个数
        int cnt = 0;
        int ans = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};


        public int orangesRotting(int[][] grid) {
            // 就是层序遍历：BFS
            // 每次遍历新加的腐烂的橘子

            int m = grid.length;
            int n = grid[0].length;
            Deque<int[]> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        cnt++;
                    } else if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }

            bfs(grid, queue);

            return cnt > 0 ? -1 : ans;
        }

        public void bfs(int[][] grid, Deque<int[]> queue) {
            int m = grid.length;
            int n = grid[0].length;

            while (!queue.isEmpty()) {
                // 这一层的个数
                int size = queue.size();
                // 判断这一轮是否有新橘子被感染
                // 有的话时间才需要 + 1
                boolean hasNew = false;

                // 遍历这一层
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    for (int idx = 0; idx < 4; idx++) {
                        int nx = cur[0] + dx[idx];
                        int ny = cur[1] + dy[idx];

                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                            // 有新的感染
                            hasNew = true;
                            grid[nx][ny] = 2;
                            cnt--;
                            queue.offer(new int[]{nx, ny});
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