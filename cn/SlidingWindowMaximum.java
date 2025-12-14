package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 239 滑动窗口最大值
 * 2025-11-21 12:39:16
 * inwf
 */

public class SlidingWindowMaximum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 单调递减队列：因为如果右边比左边的大的话
            // 左边就不可能是最大值了（左边先出窗口）
            // 维护一个单调递减队列

            Deque<Integer> deque = new LinkedList<>();
            int n = nums.length;
            int[] ans = new int[n - k + 1];

            for (int i = 0; i < n; i++) {
                // 窗口左边下标：i - k + 1
                // 找到第一个大于的，再 offer
                // 因为如果队列中左边小于右边的话，这个队列左边那个元素就没用了
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                // 这个时候再 offer
                deque.offer(i);

                // 判断是否超出窗口
                if (deque.peek() < i - k + 1) {
                    deque.poll();
                }

                if (i - k + 1 >= 0) {
                    ans[i - k + 1] = nums[deque.peek()];
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        // put your test code here
        // solution.
    }
}