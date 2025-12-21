package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 295 数据流的中位数
 * 2025-12-12 23:37:32
 * inwf
 */

public class FindMedianFromDataStream {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        // 不得不说灵神的解法实在是太妙了！
        // 参考：https://leetcode.cn/problems/find-median-from-data-stream/solutions/3015873/ru-he-zi-ran-yin-ru-da-xiao-dui-jian-ji-4v22k/?envType=study-plan-v2&envId=top-100-liked
        // left 是最大堆
        // right 是最小堆
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);
        // size() 方法时间复杂度是 O(1)
        // 所以不用单独记录长度

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (left.size() == right.size()) {
                // 先放右，再放左
                right.offer(num);
                left.offer(right.poll());
            } else {
                // 先放左，再放右
                left.offer(num);
                right.offer(left.poll());
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
//        Solution solution = new FindMedianFromDataStream().new Solution();
        // put your test code here
        // solution.
    }
}