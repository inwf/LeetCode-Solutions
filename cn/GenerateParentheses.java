package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 22 括号生成
 * 2025-12-04 12:08:42
 * inwf
 */

public class GenerateParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            char[] path = new char[2 * n];
            // DFS 枚举：当前位置填左括号还是右括号
            dfs(0, 0, n, path);
            return ans;
        }

        public void dfs(int left, int right, int n, char[] path) {
            if (right == n) {
                // 这里应该是 right == n，不能是 left == n，不然会提前退出
                ans.add(new String(path));
                // 记得要 return
                return;
            }

            // 选左括号
            if (left < n) {
                path[left + right] = '(';
                dfs(left + 1, right, n, path);

                // 因为直接用下标存值，所以不用恢复现场
                // 直接覆盖即可
            }

            // 选右括号
            if (right < left) {
                path[left + right] = ')';
                dfs(left, right + 1, n, path);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // put your test code here
        // solution.
    }
}