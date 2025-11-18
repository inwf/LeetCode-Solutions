package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

import javax.security.auth.Refreshable;

/**
 * 24 两两交换链表中的节点
 * 2025-11-18 12:31:02
 * inwf
 */

public class SwapNodesInPairs {

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
        public ListNode swapPairs(ListNode head) {

            ListNode dummyHead = new ListNode(-1, head);
            ListNode cur = dummyHead;
            ListNode first = null;
            ListNode second = null;
            ListNode temp = null;

            while (cur.next !=null && cur.next.next != null){
                first = cur.next;
                second = cur.next.next;
                temp = cur.next.next.next;

                cur.next = second;
                second.next = first;
                first.next = temp;
                cur = first;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        // put your test code here
        // solution.
    }
}