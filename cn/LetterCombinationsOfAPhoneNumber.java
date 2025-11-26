package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 17 电话号码的字母组合
 * 2025-11-26 15:13:56
 * inwf
 */

public class LetterCombinationsOfAPhoneNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder path = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            // 回溯 + 剪枝
            dfs(digits, 0);
            return ans;
        }

        public void dfs(String digits, int idx) {
            // idx 代表遍历到的 digits 的下标
            if (idx == digits.length()) {
                ans.add(path.toString());
                return;
            }

            String cur = map[digits.charAt(idx) - '0'];
            for (int i = 0; i < cur.length(); i++) {
                // 选择当前字母
                path.append(cur.charAt(i));

                // 遍历下一个数字，开始下标是 idx + 1
                dfs(digits, idx + 1);

                // 恢复现场
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // put your test code here
        // solution.
    }
}