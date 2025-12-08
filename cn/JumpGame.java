package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 55 跳跃游戏
 * 2025-12-08 20:33:29
 * inwf
 */

public class JumpGame {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            // 就是合并区间
            int n = nums.length;

            // 就是当前位置
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (cur < i) {
                    return false;
                }

                cur = Math.max(cur, i + nums[i]);
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        // put your test code here
        // solution.
    }
}