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
            // 就是归并排序：递归
            // 找到中间节点 + 合并两个有序链表

            if (head == null || head.next == null) {
                return head;
            }

            // 先均分成两个链表
            ListNode mid = findMId(head);
            ListNode left = head;
            ListNode right = mid.next;
            mid.next = null;

            // 递归
            ListNode l1 = sortList(left);
            ListNode l2 = sortList(right);


            // 均分到不能均分的时候再 return 合并后的结果
            return merge(l1, l2);
        }

        public ListNode findMId(ListNode head) {
            // 返回偏左的，所以要虚拟头结点
            ListNode dummyHead = new ListNode(-1, head);
            ListNode fast = dummyHead;
            ListNode slow = dummyHead;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode merge(ListNode p1, ListNode p2) {
            // 合并两个有序链表
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

            // 找出余量
            if (p1 != null) {
                cur.next = p1;
            }

            if (p2 != null) {
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