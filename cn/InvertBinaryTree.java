package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 226 翻转二叉树
 * 2025-11-22 17:28:47
 * inwf
 */

public class InvertBinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            // dfs 太简单了，三刷的时候可以写一下
            // bfs 每层逐个交换
            bfs(root);
            return root;
        }

        public void bfs(TreeNode cur) {
            if (cur == null) {
                return;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(cur);

            while (!queue.isEmpty()) {
                cur = queue.poll();
                // 交换当前节点
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        // put your test code here
        // solution.
    }
}