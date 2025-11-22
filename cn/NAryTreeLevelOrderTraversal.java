package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 429 N 叉树的层序遍历
 * 2025-11-22 13:37:52
 * inwf
 */

public class NAryTreeLevelOrderTraversal {

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            // 二叉树层序遍历进阶版

            List<List<Integer>> ans = new ArrayList<>();
            bfs(root, ans);
            return ans;
        }

        public void bfs(Node root, List<List<Integer>> ans) {
            if (root == null) {
                return;
            }

            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                // 当前层节点个数
                int n = queue.size();

                for (int i = 0; i < n; i++) {
                    Node cur = queue.poll();
//                    for (Node next : cur.children) {
//                        if (next != null) {
//                            queue.offer(next);
//                        }
//                    }
                    temp.add(cur.val);
                }
                ans.add(temp);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        // put your test code here
        // solution.
    }
}