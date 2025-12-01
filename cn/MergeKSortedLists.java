package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 23 合并 K 个升序链表
 * 2025-12-01 23:32:18
 * inwf
 */

public class MergeKSortedLists {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // 用小根堆，每次 poll() 出最小值，然后 offer 进刚才 poll 的下一个
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

            for (ListNode p : lists) {
                if (p != null) {
                    queue.offer(p);
                }
            }

            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            while (!queue.isEmpty()) {
                ListNode temp = queue.poll();
                cur.next = temp;
                if (temp.next != null) {
                    queue.offer(temp.next);
                }

                cur = cur.next;
            }

            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here
        // solution.
    }
}