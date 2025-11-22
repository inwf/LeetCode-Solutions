package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 104 二叉树的最大深度
 * 2025-11-22 15:33:21
 * inwf
 */

public class MaximumDepthOfBinaryTree {

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
        public int maxDepth(TreeNode root) {
            return bfs(root);
        }

        public int bfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int dep = 0;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                // 当前层节点个数
                int n = queue.size();

                // 能进到这说明这一层存在
                // 如果这一层不存在的话，n = 0，就不会进入 while 循环了
                dep++;
                for (int i = 0; i < n; i++) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            return dep;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        // put your test code here
        // solution.
    }
}