package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 116 填充每个节点的下一个右侧节点指针
 * 2025-11-22 15:13:02
 * inwf
 */

public class PopulatingNextRightPointersInEachNode {

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    */

    class Solution {
        public Node connect(Node root) {
            // 层序遍历
            bfs(root);
            return root;
        }

        public void bfs(Node root) {
            if (root == null) {
                return;
            }

            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                // 这一层节点个数
                int n = queue.size();

                for (int i = 0; i < n; i++) {
                    Node cur = queue.poll();

                    if (i != n - 1) {
                        // 不是最后一个就指向下一个
                        cur.next = queue.peek();
                    } else {
                        // 是最后一个就指向 null
                        cur.next = null;
                    }

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        // put your test code here
        // solution.
    }
}