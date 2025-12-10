package leetcode.editor.cn;

import java.util.*;

/**
 * 155 最小栈
 * 2025-12-10 23:48:36
 * inwf
 */

public class LeetCodeMinStack {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        // 法1：两倍空间，同时存元素和前缀最小值
        // 法2：https://leetcode.cn/problems/min-stack/solutions/42521/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38
        // 只存最小栈变化的时候前一个最小值和当前最小值

        private final Deque<int[]> stk = new LinkedList<>();
        // 每个节点有两个值，[0] 是元素值，[1] 是前缀最小值

        public MinStack() {
            // 初始化，先放个哨兵进去，这样后面就不用单独判断栈空的状态了
            stk.push(new int[]{0, Integer.MAX_VALUE});
        }

        public void push(int val) {
            stk.push(new int[]{val, Math.min(val, getMin())});
        }

        public void pop() {
            stk.pop();

        }

        public int top() {
            return stk.peek()[0];
        }

        public int getMin() {
            return stk.peek()[1];
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
//        Solution solution = new MinStack().new Solution();
        // put your test code here
        // solution.
    }
}