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

            int[] d = new int[numCourses];
            // 邻接表
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                g.add(new ArrayList<>());
            }

            // 规则数
            int n = prerequisites.length;

            // 构建入度和邻接表
            for (int i = 0; i < n; i++) {
                // a <- b
                int a = prerequisites[i][0];
                int b = prerequisites[i][1];
                d[a]++;
                g.get(b).add(a); // 邻接表（ b -> a ）
            }

            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (d[i] == 0) {
                    queue.offer(i);
                }
            }

            bfs(queue, g, d);

            if (cnt != numCourses) {
                return false;
            }

            return true;
        }

        public void bfs(Deque<Integer> queue, List<List<Integer>> g, int[] d) {
            while (!queue.isEmpty()) {
                // 删除 cur 这个节点
                int cur = queue.poll();
                cnt++;

                int n = g.get(cur).size();
                for (int i = 0; i < n; i++) {
                    // 找出课程 cur 的后继节点
                    // 删除 cur 后，把他的后继节点的入度 - 1
                    int next = g.get(cur).get(i);
                    d[next]--;

                    if (d[next] == 0) {
                        // 入队
                        queue.offer(next);
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        // put your test code here
        // solution.
    }
}