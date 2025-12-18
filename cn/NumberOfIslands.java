package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 200 岛屿数量
 * 2025-12-11 13:41:02
 * inwf
 */

public class NumberOfIslands {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            // 网格图遍历，找到岛屿就 DFS 遍历染色
            // DFS

            int ans = 0;
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        dfs(grid, i, j);
                    }
                }
            }

            return ans;
        }

        public void dfs(char[][] grid, int x, int y) {
            int m = grid.length;
            int n = grid[0].length;
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
                return;
            }

            // 染色，此时一定在岛上
            grid[x][y] = '0';

            dfs(grid, x, y + 1);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x - 1, y);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        // put your test code here
        // solution.
    }
}