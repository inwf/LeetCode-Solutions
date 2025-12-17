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
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            // bfs 模板提
            bfs(root);
            return ans;
        }

        public void bfs(TreeNode root) {
            if (root == null) {
                return;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> temp = new ArrayList<>(n);

                for (int i = 0; i < n; i++) {
                    TreeNode cur = queue.poll();
                    temp.add(cur.val);

                    if (cur.left!=null){
                        queue.offer(cur.left);
                    }
                    if (cur.right!=null){
                        queue.offer(cur.right);
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