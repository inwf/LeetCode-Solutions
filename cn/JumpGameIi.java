package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 45 跳跃游戏 II
 * 2025-12-08 20:38:40
 * inwf
 */

public class JumpGameIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            // 造桥游戏
            // 参考灵神：https://leetcode.cn/problems/jump-game-ii/solutions/2926993/tu-jie-yi-zhang-tu-miao-dong-tiao-yue-yo-h2d4/?envType=study-plan-v2&envId=top-100-liked

            int cur = 0;
            int maxRight = 0;
            int n = nums.length;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (i > cur) {
                    cur = maxRight;
                    ans++;
                }
                maxRight = Math.max(maxRight, i + nums[i]);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        // put your test code here
         solution.jump(new int[]{2,3,1,1,4});
    }
}