package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 42 接雨水
 * 2025-12-14 12:28:00
 * inwf
 */

public class TrappingRainWater {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            // 找出前缀/后缀最高

            int ans = 0;
            int n = height.length;
            int[] lMax = new int[n];
            int[] rMax = new int[n];
            lMax[0] = height[0];
            rMax[n - 1] = height[n - 1];

            for (int i = 1; i < n; i++) {
                lMax[i] = Math.max(lMax[i - 1], height[i]);
            }

            for (int i = n - 2; i >= 0; i--) {
                rMax[i] = Math.max(rMax[i + 1], height[i]);
            }

            for (int i = 0; i < n; i++) {
                ans += Math.min(lMax[i], rMax[i]) - height[i];
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        // put your test code here
        // solution.
    }
}