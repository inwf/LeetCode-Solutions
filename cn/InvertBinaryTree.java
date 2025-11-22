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
            // bfs 对于每一层每个节点，先让这个节点的子节点交换一下，再将子节点入队
            bfs(root);
            return root;
        }

        public void bfs(TreeNode root) {
            if (root == null) {
                return;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){

                // 交换当前节点的左右子节点
                TreeNode cur = queue.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
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