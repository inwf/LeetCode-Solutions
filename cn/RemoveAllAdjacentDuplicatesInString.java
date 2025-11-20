package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 1047 删除字符串中的所有相邻重复项
 * 2025-11-20 23:27:42
 * inwf
 */

public class RemoveAllAdjacentDuplicatesInString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> stack = new LinkedList<>();
            int n = s.length();
            String str = "";

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);

                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            while (!stack.isEmpty()) {
                str = stack.pop() + str;
            }

            return str;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        // put your test code here
        // solution.
    }
}