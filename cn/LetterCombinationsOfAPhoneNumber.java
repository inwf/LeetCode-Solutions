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
        StringBuilder path = new StringBuilder();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wzyx"};

        public List<String> letterCombinations(String digits) {
            // 回溯 + 剪枝
            dfs(digits, 0);
            return ans;
        }

        public void dfs(String digits, int idx) {
            // idx 是当前遍历到哪一个下标了，刚开始是 0 表示从 0 开始选择选哪个字母
            if (idx == digits.length()) {
                ans.add(path.toString());
                return;
            }

            String cur = map[digits.charAt(idx) - '0'];
            for (int i = 0; i < cur.length(); i++) {
                // 选择 c
                char c = cur.charAt(i);
                path.append(c);

                // 进入选完 c 后的 dfs
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