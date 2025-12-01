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
            // 法1：灵神的交错链表
            // 法2：哈希表：key 是原链表，value 是新链表

            Map<Node, Node> map = new HashMap<>();
            Node p = head;

            // 构建 map
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
                map.get(p).next = map.get(p.next);
                map.get(p).random = map.get(p.random);
                p=p.next;
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