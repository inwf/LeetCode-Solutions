package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 739 每日温度
 * 2025-12-10 13:37:39
 * inwf
 */

public class DailyTemperatures {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            // 单调递减栈：遇到大的就 pop 直到把大的 push 进去后还是递减的
            // 参考：https://leetcode.cn/problems/daily-temperatures/solutions/71433/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/?envType=study-plan-v2&envId=top-100-liked

            int n = temperatures.length;
            int[] ans = new int[n];
            Deque<Integer> stk = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                    int prev = stk.pop();
                    ans[prev] = i - prev;
                }

                stk.push(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        // put your test code here
        // solution.
    }
}