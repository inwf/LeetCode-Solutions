package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 32 最长有效括号
 * 2025-12-12 21:22:40
 * inwf
 */

public class LongestValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            // 括号匹配，典型的用栈来写
            // 还是得要哨兵节点
            // stk 存放还没被匹配的下标

            int ans = 0;
            Deque<Integer> stk = new LinkedList<>();
            stk.push(-1);
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    // 直接 push
                    stk.push(i);
                } else {
                    // 当前是 ')'
                    stk.pop();
                    if (stk.isEmpty()) {
                        // 哨兵都被 pop() 了
                        stk.push(i);
                    } else {
                        int start = stk.peek() + 1;
                        int end = i;
                        ans = Math.max(ans, end - start + 1);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        // put your test code here
        // solution.
    }
}