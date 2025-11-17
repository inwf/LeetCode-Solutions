package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 203 移除链表元素
 * 2025-11-17 21:37:15
 * inwf
 */

public class RemoveLinkedListElements {

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
        public ListNode removeElements(ListNode head, int val) {
            ListNode myHead = new ListNode(1, head);
            ListNode now = myHead;
            while (now.next != null) {
                if (now.next.val == val) {
                    now.next = now.next.next;
                } else {
                    now = now.next;
                }
            }
            return myHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        // put your test code here
        // solution.
    }
}