package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 138 随机链表的复制
 * 2025-12-01 18:44:44
 * inwf
 */

public class CopyListWithRandomPointer {

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    */

    class Solution {
        public Node copyRandomList(Node head) {
            // 法1：灵神交错链表
            // 法2：哈希表

            // 构建哈希表
            Map<Node, Node> map = new HashMap<>();
            Node p = head;
            while (p != null) {
                Node temp = new Node(p.val);
                map.put(p, temp);
                p = p.next;
            }

            // 构建新链表
            Node dummyHead = new Node(-1);
            dummyHead.next = map.get(head);
            p = head;

            while (p != null) {
                Node temp = map.get(p);
                temp.next = map.get(p.next);
                temp.random = map.get(p.random);
                p = p.next;
            }

            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
        // put your test code here
        // solution.
    }
}