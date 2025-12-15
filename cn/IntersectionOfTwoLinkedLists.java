package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 160 相交链表
 * 2025-11-18 17:59:24
 * inwf
 */

public class IntersectionOfTwoLinkedLists {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 要么同时到 null
            // 要么同时到相遇点

            ListNode p1 = headA;
            ListNode p2 = headB;

            while (p1 != p2) {
                if (p1 == null) {
                    p1 = headB;
                } else {
                    p1 = p1.next;
                }

                if (p2 == null) {
                    p2 = headA;
                } else {
                    p2 = p2.next;
                }
            }

            return p1;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        // put your test code here
        // solution.
    }
}