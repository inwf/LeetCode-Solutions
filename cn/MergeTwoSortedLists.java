package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 21 合并两个有序链表
 * 2025-11-30 19:03:55
 * inwf
 */

public class MergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 每次把两个链表较小的节点插入新链表

            ListNode dymmyHead = new ListNode(-1);
            ListNode cur = dymmyHead;

            ListNode p1 = list1;
            ListNode p2 = list2;
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

            if (p1 == null) {
                cur.next = p2;
            }
            if (p2 == null) {
                cur.next = p1;
            }
            return dymmyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here
        // solution.
    }
}