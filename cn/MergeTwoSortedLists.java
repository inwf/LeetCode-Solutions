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
            // 新建一个新的链表
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }

                cur = cur.next;
            }

            if (list1 == null) {
                cur.next = list2;
            } else {
                cur.next = list1;
            }

            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here
        // solution.
    }
}