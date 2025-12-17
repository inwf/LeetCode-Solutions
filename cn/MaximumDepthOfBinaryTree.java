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
            // dfs 太简单了
            // 用 bfs 层序遍历
            return bfs(root);
        }

        public int bfs(TreeNode cur) {
            int ans = 0;
            Deque<TreeNode> queue = new LinkedList<>();
            // 这里要特判一下
            if (cur != null) {
                queue.offer(cur);
            }

            while (!queue.isEmpty()) {
                int n = queue.size();
                // 能进来就说明这一层有节点
                ans++;
                for (int i = 0; i < n; i++) {
                    cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        // put your test code here
        // solution.
    }
}