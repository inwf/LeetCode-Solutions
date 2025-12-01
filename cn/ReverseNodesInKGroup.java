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
            // 统计链表长度
            int n = 0;
            ListNode cnt = head;
            while (cnt != null) {
                n++;
                cnt = cnt.next;
            }

            // dummy: 虚拟头节点，为了方便处理原本的头节点 head 发生变化的情况。
            // p0: “守门员”。它永远站在待翻转组的前一个位置。它负责把翻转好的一组接回主链表。
            // cur: “当前工兵”。它负责在组内遍历。
            // pre: “新头领”。在翻转过程中，它会变成当前组新的头节点。

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode pre = null;
            ListNode temp = null;
            ListNode cur = head;
            ListNode p0 = dummyHead;

            // 总共翻转 n/k 轮
            for (int i = 0; i < n / k; i++) {
                // 每轮翻转 k 个节点
                for (int j = 0; j < k; j++) {
                    temp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = temp;
                }

                // p0 是每轮翻转的前一个节点
                // 每轮翻转完成后用 p0
                // nx 是每轮翻转完后最左边的节点（这时候翻转完的链表朝左）
                ListNode nx = p0.next;
                p0.next = pre;
                nx.next = cur;
                // 把 p0 设置成下一轮翻转组的前一个节点
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