package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 102 二叉树的层序遍历
 * 2025-11-21 20:30:26
 * inwf
 */

public class BinaryTreeLevelOrderTraversal {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            bfs(root, ans);

            return ans;
        }

        public void bfs(TreeNode root, List<List<Integer>> ans) {
            if (root == null) {
                return;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                // 用来存这一层的所有节点
                List<Integer> temp = new ArrayList<>();
                // 这一层有 n 个节点
                int n = queue.size();

                // 一口气把这一层全 poll，把下一层全 offer
                for (int i = 0; i < n; i++) {
                    TreeNode now = queue.poll();
                    temp.add(now.val);

                    if (now.left != null) {
                        queue.offer(now.left);
                    }
                    if (now.right != null) {
                        queue.offer(now.right);
                    }
                }
                ans.add(temp);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        // put your test code here
        // solution.
    }
}