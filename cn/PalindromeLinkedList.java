package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 234 回文链表
 * 2025-11-30 18:47:24
 * inwf
 */

public class PalindromeLinkedList {

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
        public boolean isPalindrome(ListNode head) {
            // 反转链表 + 快慢指针找链表中点
            ListNode mid = findMid(head);
            ListNode left = head;
            ListNode right = reverse(mid);

            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                right = right.next;
                left = left.next;
            }

            return true;
        }

        // 反转链表
        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode temp = null;

            while (cur != null) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }

            // 注意：此时 cur = null，已经反转完成
            return pre;
        }

        // 快慢指针找链表中点
        public ListNode findMid(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here
        // solution.
    }
}