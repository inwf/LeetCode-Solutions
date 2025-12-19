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
            // 左括号随时都能加的，右括号只有左括号数量大于右括号数量的时候才能加
            char[] path = new char[2 * n];
            dfs(0, 0, n, path);
            return ans;
        }

        public void dfs(int left, int right, int n, char[] path) {
            if (right == n) {
                // 注意这里是右括号个数 = n 的时候才 return，否则会提前退出
                ans.add(new String(path));
                return;
            }

            // 选左括号
            if (left < n) {
                path[left + right] = '(';
                dfs(left + 1, right, n, path);
            }
            // 为什么不用恢复现场？因为 path 和 idx 配合直接覆盖了 path[idx]

            // 选右括号
            if (left > right) {
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