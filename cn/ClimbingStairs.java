package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 70 爬楼梯
 * 2025-12-04 14:17:53
 * inwf
 */

public class ClimbingStairs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n==1){
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        // put your test code here
        // solution.
    }
}