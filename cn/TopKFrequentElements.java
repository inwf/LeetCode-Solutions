package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 347 前 K 个高频元素
 * 2025-11-21 14:24:41
 * inwf
 */

public class TopKFrequentElements {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // 用小根堆，如果新元素比小根堆的堆顶元素小的话，就 pop 然后 push
            // 需要自己重写排序规则
            // key 是元素，value 是出现次数

            Map<Integer, Integer> cnt = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 小根堆
            int[] ans = new int[k];

            int n = nums.length;
            for (int i = 0; i < n; i++) {
                cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            }

            for (int i : cnt.keySet()) {
                int[] temp = new int[2];
                temp[0] = i;
                temp[1] = cnt.get(i);

                pq.offer(temp);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            for (int i = 0; i < k; i++) {
                ans[i] = pq.poll()[0];
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        // put your test code here
        solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}