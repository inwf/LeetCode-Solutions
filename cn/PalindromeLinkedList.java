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
            // 寻找中间节点 + 翻转链表
            // 中间节点找的是偏右的那个
            ListNode mid = findMid(head);
            ListNode right = reverse(mid);
            ListNode left = head;

            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }

        public ListNode findMid(ListNode head) {
            // 快慢指针找中间节点（靠右的那个）
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode reverse(ListNode head) {
            // 翻转节点
            // 返回的新头是 pre
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = null;

            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                // 右移一位
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here
        // solution.
    }
}