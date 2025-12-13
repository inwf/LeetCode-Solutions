package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 11 盛最多水的容器
 * 2025-12-13 23:36:28
 * inwf
 */

public class ContainerWithMostWater {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            // 从两边开始，每次只缩短高度较短的那根
            // 每次记录长度

            int ans = 0;
            int l = 0;
            int r = height.length - 1;
            while (l <= r) {
                int h = Math.min(height[l], height[r]);
                ans = Math.max(ans, h * (r - l));
                if (height[l] < height[r]) {
                    // 移动 l
                    l++;
                } else {
                    // 移动 r
                    r--;
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        // put your test code here
        // solution.
    }
}