package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 25 K 个一组翻转链表
 * 2025-12-01 13:58:26
 * inwf
 */

public class ReverseNodesInKGroup {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            // 先统计长度
            int n = 0;
            ListNode cnt = head;
            while (cnt != null) {
                cnt = cnt.next;
                n++;
            }

            // 有点像反转链表
            // 但是要维护一下每一轮反转的前一个节点
            // p0 是待翻转组的前一个位置
            // 每一轮都是将 cur 指向前一个节点
            ListNode dummyHead = new ListNode(-1, head);
            ListNode p0 = dummyHead;
            ListNode cur = head;
            ListNode pre = null;
            ListNode next = null;

            for (int i = 0; i < n / k; i++) {
                // 总共反转 n / k 轮
                for (int j = 0; j < k; j++) {
                    // 每轮反转 k 个节点
                    next = cur.next;
                    cur.next = pre;
                    // 右移一位
                    pre = cur;
                    cur = next;
                }
                // 上面的 for 循环结束后，cur 是下一轮的开始节点
                // pre 是反转后的节点的新头

                // 将反转的链表组合到大链表里面去
                // p0 是每轮翻转的前一个节点
                // nx 是 p0 原先的下一个节点，现在变成反转后的最左的节点了（从右往左）
                ListNode nx = p0.next;
                p0.next = pre;
                nx.next = cur;

                // 把 p0 更新成下一轮待反转的链表的前一个节点
                p0 = nx;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        // put your test code here
        // solution.
    }
}