package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 101 对称二叉树
 * 2025-11-22 17:38:46
 * inwf
 */

public class SymmetricTree {

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
        public boolean isSymmetric(TreeNode root) {
            // bfs
            // 两个两个加，每次左边放一个右边放一个
            return bfs(root);
        }

        public boolean bfs(TreeNode root) {
            if (root == null) {
                return true;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {
                // L 是左边那个子树，R 是右边那个子树
                TreeNode L = queue.poll();
                TreeNode R = queue.poll();

                if (L == null && R == null) {
                    continue;
                }

                if ((L == null && R != null) || (L != null && R == null)) {
                    return false;
                }

                if (L.val != R.val) {
                    return false;
                }

                // 当前两个节点是对称的
                // 左边放子左节点，右边放右子节点
                queue.offer(L.left);
                queue.offer(R.right);

                // 同理
                queue.offer(L.right);
                queue.offer(R.left);
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        // put your test code here
        // solution.
    }
}