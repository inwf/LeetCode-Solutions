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
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]); // 递增
            int n = nums.length;
            int[] ans = new int[k];

            for (int i = 0; i < n; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            // 遍历 map，可以用 forEach 遍历，也可以用 keySet 遍历
            for (int i : map.keySet()) {
                int[] temp = new int[2];
                temp[0] = i;
                temp[1] = map.get(i);
//                if (pq.size() < k) {
//                    pq.offer(temp);
//                } else {
//                    if (pq.peek()[1] < temp[1]) {
//                        pq.poll();
//                        pq.offer(temp);
//                    }
//                }

                // 优化版：直接 offer 如果 pq.size() > k 再 poll
                pq.offer(temp);
                if(pq.size() > k){
                    pq.poll();
                }
            }

            int idx = 0;
            while (!pq.isEmpty()) {
                ans[idx++] = pq.poll()[0];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        // put your test code here
         solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}