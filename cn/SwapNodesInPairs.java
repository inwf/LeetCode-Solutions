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
            // 可以在草稿纸上画出这个过程，还是很好理解的
            // 一共四个辅助节点
            // 每次调换 cur 后面两个节点的顺序
            // 所以要用 dummyHead

            ListNode dummyHead = new ListNode(-1,head);
            ListNode cur = dummyHead;
            ListNode first = null;
            ListNode second = null;
            ListNode temp = null;

            while (cur.next != null && cur.next.next != null) {
                first = cur.next;
                second = cur.next.next;
                temp = cur.next.next.next;

                // 这里可以在草稿纸上画出变换过程，很好理解的
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