package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 142 环形链表 II
 * 2025-11-18 21:02:11
 * inwf
 */

public class LinkedListCycleIi {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // 典型题
            // 返回交点

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    // 有环
                    ListNode temp = head;
                    while (temp != slow) {
                        temp = temp.next;
                        slow = slow.next;
                    }

                    return temp;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        // put your test code here
        // solution.
    }
}