package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 131 分割回文串
 * 2025-11-26 23:29:45
 * inwf
 */

public class PalindromePartitioning {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            // DFS，当前是回味串才进入 dfs
            dfs(s, 0);
            return ans;
        }

        public void dfs(String s, int startIndex) {
            if (startIndex == s.length()) {
                ans.add(new ArrayList<>(path));
                // 记得返回
                return;
            }

            for (int i = startIndex; i < s.length(); i++) {
                if (pd(s, startIndex, i)) {
                    // 当前分割是回文串
                    path.add(s.substring(startIndex, i + 1));

                    // 进入 dfs
                    dfs(s, i + 1);

                    // 恢复现场
                    path.remove(path.size() - 1);
                }
            }
        }

        public boolean pd(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        // put your test code here
        // solution.
    }
}