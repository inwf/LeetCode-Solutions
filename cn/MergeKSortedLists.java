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
            // 小根堆，每次加入最小的头结点

            PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
            int n = lists.length;

            for (int i = 0; i < n; i++) {
                if (lists[i] != null) {
                    heap.offer(lists[i]);
                }
            }

            // 构建链表
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            while (!heap.isEmpty()) {
                ListNode temp = heap.poll();
                cur.next = temp;
                cur = cur.next;
                if (temp.next != null) {
                    // 将该节点下一个加入小根堆
                    heap.offer(temp.next);
                }
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