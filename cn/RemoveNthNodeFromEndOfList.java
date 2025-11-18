package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 19 删除链表的倒数第 N 个结点
 * 2025-11-18 17:41:58
 * inwf
 */

public class RemoveNthNodeFromEndOfList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode fast = dummyHead;
            ListNode slow = dummyHead;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;

            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here
        // solution.
    }
}