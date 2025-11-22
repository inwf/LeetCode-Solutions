package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 515 在每个树行中找最大值
 * 2025-11-22 15:06:13
 * inwf
 */

public class FindLargestValueInEachTreeRow {

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
        public List<Integer> largestValues(TreeNode root) {
            // 层序遍历
            List<Integer> ans = new ArrayList<>();
            bfs(root, ans);
            return ans;
        }

        public void bfs(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                // 这一层节点个数
                int n = queue.size();
                int mx = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {

                    TreeNode cur = queue.poll();

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }

                    mx = Math.max(mx, cur.val);
                }
                ans.add(mx);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
        // put your test code here
        // solution.
    }
}