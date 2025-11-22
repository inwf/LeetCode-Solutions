package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 637 二叉树的层平均值
 * 2025-11-22 13:33:45
 * inwf
 */

public class AverageOfLevelsInBinaryTree {

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
        public List<Double> averageOfLevels(TreeNode root) {
            // 就是中序遍历然后求和再平均

            List<Double> ans = new ArrayList<>();
            bfs(root, ans);
            return ans;
        }

        public void bfs(TreeNode root, List<Double> ans) {
            if (root == null) {
                return;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                // 这一层的个数
                int n = queue.size();
                double sum = 0;

                for (int i = 0; i < n; i++) {
                    TreeNode now = queue.poll();

                    if (now.left != null) {
                        queue.offer(now.left);
                    }
                    if (now.right != null) {
                        queue.offer(now.right);
                    }

                    sum += now.val;
                }
                ans.add(sum / n);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
        // put your test code here
        // solution.
    }
}