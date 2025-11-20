package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 150 逆波兰表达式求值
 * 2025-11-20 23:45:40
 * inwf
 */

public class EvaluateReversePolishNotation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            // 用 Deque 模拟栈
            // 逆波兰表达式就是后缀表达式

            Deque<Integer> stack = new LinkedList<>();

            int n = tokens.length;

            for (int i = 0; i < n; i++) {
                String token = tokens[i];
                if (token.equals("+")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    int c = a + b;
                    stack.push(c);
                } else if (token.equals("-")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    int c = a - b;
                    stack.push(c);
                } else if (token.equals("*")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    int c = a * b;
                    stack.push(c);
                } else if (token.equals("/")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    int c = a / b;
                    stack.push(c);
                } else {
                    int x = Integer.parseInt(token);
                    stack.push(x);
                }
            }

            return stack.pop();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        // put your test code here
        // solution.
    }
}