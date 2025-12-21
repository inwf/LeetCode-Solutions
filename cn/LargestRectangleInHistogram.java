package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 84 柱状图中最大的矩形
 * 2025-12-10 13:58:36
 * inwf
 */

public class LargestRectangleInHistogram {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            // 根据下标遍历所有高度
            // 单调递增栈（找到了比当前小的会出现 pop() 等操作）
            // 右边找到第一个小于当前高度的话就找到了有边界
            // 此时左边界就是 pop() 完后的栈顶（单调递增栈）
            // 遍历矩形开始的下标

            int n = heights.length;
            int ans = 0;
            Deque<Integer> stk = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                    // 找到了比 stk.peek() 小的高度
                    int h = heights[stk.pop()];
                    int left = stk.isEmpty() ? 0 : stk.peek() + 1;
                    int right = i - 1;
                    int w = right - left + 1;
                    ans = Math.max(ans, w * h);
                }
                stk.push(i);
            }

            while (!stk.isEmpty()) {
                // 处理最后面几个
                // 现在 stk 是单调递增的
                int h = heights[stk.pop()];
                int left = stk.isEmpty() ? 0 : stk.peek() + 1;
                int right = n - 1;
                int w = right - left + 1;
                ans = Math.max(ans, w * h);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        // put your test code here
        // solution.
    }
}