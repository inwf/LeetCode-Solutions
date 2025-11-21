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
            // 单调队列（严格来说看成双端队列即可）
            // 维护一个单调递减的队列
            // 入队的时候用 while 入
            // 参考：https://www.bilibili.com/video/BV1bM411X72E
            // 注意：存的是下标不是元素

            Deque<Integer> queue = new LinkedList<>();
            int n = nums.length;
            int[] ans = new int[n - k + 1];

            for (int i = 0; i < n; i++) {
                // 入队，找到单调递减队列中可以入的位置
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }

                queue.offer(i);

                if (queue.peek() < i - k + 1) {
                    queue.poll();
                }
                if (i - k + 1 >= 0) {
                    ans[i - k + 1] = nums[queue.peek()];
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