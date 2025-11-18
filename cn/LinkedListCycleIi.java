package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 142 环形链表 II
 * 2025-11-18 21:02:11
 * inwf
 */

public class LinkedListCycleIi {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode fast = dummyHead;
            ListNode slow = dummyHead;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    // 有环
                    ListNode idx = dummyHead;
                    while (idx != slow) {
                        idx = idx.next;
                        slow = slow.next;
                    }
                    return idx;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        // put your test code here
        // solution.
    }
}