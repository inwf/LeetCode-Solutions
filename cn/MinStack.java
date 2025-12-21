package leetcode.editor.cn;

import java.util.*;

/**
 * 155 最小栈
 * 2025-12-21 12:24:50
 * inwf
 */

public class MinStack {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        Deque<int[]> stk = new LinkedList<>();

        public MinStack() {
            // 先放个哨兵节点进去，不然方第一个的时候获取不到 getMin()
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