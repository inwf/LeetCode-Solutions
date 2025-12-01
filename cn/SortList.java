package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 148 排序链表
 * 2025-12-01 19:03:30
 * inwf
 */

public class SortList {

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
        public ListNode sortList(ListNode head) {
            // 就是归并排序 = 找到链表中间节点 + 合并有序链表
            if (head == null || head.next == null) {
                return head;
            }

            // 注意，这里要找中间偏左的节点
            ListNode mid = findMidList(head);
            ListNode head2 = mid.next;
            // 分割两个链表
            mid.next = null;

            ListNode l1 = sortList(head);
            ListNode l2 = sortList(head2);

            return mergeList(l1, l2);
        }

        // 找到中间节点
        public ListNode findMidList(ListNode head) {
            ListNode fast = new ListNode(-1);
            fast.next = head;
            ListNode slow = fast;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }

        // 合并两个有序链表
        public ListNode mergeList(ListNode p1, ListNode p2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    cur.next = p1;
                    p1 = p1.next;
                } else {
                    cur.next = p2;
                    p2 = p2.next;
                }

                cur = cur.next;
            }

            if (p1 != null) {
                cur.next = p1;
            } else {
                cur.next = p2;
            }

            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        // put your test code here
        // solution.
    }
}