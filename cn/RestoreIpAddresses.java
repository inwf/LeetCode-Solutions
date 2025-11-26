package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 93 复原 IP 地址
 * 2025-11-26 23:43:33
 * inwf
 */

public class RestoreIpAddresses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            // 这题很妙，判断签前导 0 的方法很妙啊！
            // https://leetcode.cn/problems/restore-ip-addresses/solutions/3727037/liang-chong-fang-fa-san-zhong-xun-huan-h-hxak/
            // DFS 就行

            dfs(s, 0, 0);
            return ans;
        }

        // cnt 是已经选了几段了，cnt = 4 的时候就要判断是否遍历完了
        public void dfs(String s, int startIndex, int cnt) {
            // 判断 cnt == 4 也可以
            if (path.size() == 4) {
                if (startIndex == s.length()) {
                    ans.add(String.join(".", path));
                }
                return;
            }

            int ipVal = 0;
            for (int i = startIndex; i < s.length() && i < startIndex + 3; i++) {
                ipVal = ipVal * 10 + (s.charAt(i) - '0');
                if (ipVal > 255) {
                    break;
                }

                // ipVal 符合 0 - 255
                path.add(s.substring(startIndex, i + 1));

                // 进入 dfs
                dfs(s, i + 1, cnt + 1);

                // 恢复现场
                path.remove(path.size() - 1);

                // 不能有前导 0，这里就不再往右分割了！
                if (ipVal == 0){
                    break;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        // put your test code here
        // solution.
    }
}