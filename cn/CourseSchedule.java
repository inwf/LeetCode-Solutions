package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 207 课程表
 * 2025-12-11 20:06:54
 * inwf
 */

public class CourseSchedule {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int cnt = 0;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 就是拓扑排序
            // 如果有环，说明不可能修完，那么返回 false
            // 否则返回 true
            // 入度为 0 的才有可能入队

            // 记录入度
            int[] d = new int[numCourses];
            // 邻接表
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                g.add(new ArrayList<>());
            }

            for (int[] x : prerequisites) {
                int a = x[0];
                int b = x[1]; // b -> a
                g.get(b).add(a);
                d[a]++;
            }

            return bfs(numCourses, g, d);
        }

        public boolean bfs(int numCourses, List<List<Integer>> g, int[] d) {
            // 只有入度为 0 的才能入队
            Deque<Integer> queue = new LinkedList<>();

            for (int i = 0; i < numCourses; i++) {
                if (d[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                cnt++;

                for (int nx : g.get(cur)) {
                    // cur -> nx
                    d[nx]--;
                    if (d[nx] == 0) {
                        queue.offer(nx);
                    }
                }
            }

            return cnt == numCourses;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        // put your test code here
        // solution.
    }
}