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
            // 单调递减栈
            // 参考：https://leetcode.cn/problems/daily-temperatures/solutions/71433/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/?envType=study-plan-v2&envId=top-100-liked

            int n = temperatures.length;
            int[] ans = new int[n];
            // 栈和队列都这样写
            // 栈：push 和 pop （左边、左边）
            // 队列：offer 和 poll （右边、左边）
            Deque<Integer> stk = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                // 当前非空且今日温度 > 栈顶维温度
                while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                    int prev = stk.pop();
                    ans[prev] = i - prev;
                }

                // 当前栈要么空，要么已经递减
                stk.push(i);
            }

            // 最后几个元素：此时 stk 还有最后几个温度递减元素，但是 ans 默认为 0 了
//            System.out.println(stk);
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