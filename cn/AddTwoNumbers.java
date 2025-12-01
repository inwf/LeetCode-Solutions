package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 2 两数相加
 * 2025-12-01 12:26:47
 * inwf
 */

public class AddTwoNumbers {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            // 用来求和当前两个节点的，如果 > 10，说明要进位
            int sum = 0;

            while (l1 != null || l2 != null || sum != 0) {
                // 有一个存在就要继续求和
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                ListNode temp = new ListNode(sum%10);
                sum/=10;
                cur.next = temp;
                cur = cur.next;
            }

            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // put your test code here
        // solution.
    }
}