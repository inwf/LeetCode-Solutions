package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 20 有效的括号
 * 2025-11-20 21:28:19
 * inwf
 */

public class ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            // 用 Deque 模拟栈
            Deque<Character> stack = new ArrayDeque<>();
            int n = s.length();

            for (int i = 0; i < n; i++) {
                // 左括号直接入栈
                // 右括号判断栈顶是否匹配
                // 不匹配直接返回 false

                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char temp = stack.pop();
                    if (c == ')' && temp != '(') {
                        return false;
                    } else if (c == ']' && temp != '[') {
                        return false;
                    } else if (c == '}' && temp != '{') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // put your test code here
        // solution.
    }
}