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
            // 栈模拟题
            // 左括号直接入，右括号就匹配

            Deque<Character> stack = new LinkedList<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
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
                    }
                    if (c == ']' && temp != '[') {
                        return false;
                    }
                    if (c == '}' && temp != '{') {
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