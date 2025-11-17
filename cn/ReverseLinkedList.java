package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 206 反转链表
 * 2025-11-17 23:03:40
 * inwf
 */

public class ReverseLinkedList {

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
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode temp = null;

            while (cur != null) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }

            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
//         solution.reverseList(new ListNode({[1,2,3,4,5]}));
    }
}