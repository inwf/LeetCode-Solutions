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
            int ans = 0;
            int n = s.length();
            Deque<Integer> stk = new LinkedList<>();
            // -1 用来当哨兵，做为最长有效子串的开始下标减 1
            // 从 0 开始，所以先存 -1
            stk.offer(-1);

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    // 直接存，stk 存下标
                    stk.push(i);
                } else {
                    // 此时是 ")"
                    stk.pop();
                    // 先 pop()
                    // 如果 pop() 完后为空的话说明把哨兵都 pop() 了
                    // 这时候栈要重新放一个开始下标减 1
                    if (stk.isEmpty()) {
                        // 新的哨兵
                        stk.push(i);
                    } else {
                        // 否则计算一下现在最长长度
                        // 此时栈顶就是开始的下标减去 1
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