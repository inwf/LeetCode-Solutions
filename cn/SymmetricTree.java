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
            // 对称判断，所以一次把镜像对称的 左节点和右节点 全取出来
            // 然后按照镜像对称的顺序加入队列
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
                // 先取左再去右，所以下面是先加左再加右（左的左和右的右匹配）
                TreeNode L = queue.poll();
                TreeNode R = queue.poll();

                if (L == null && R == null) {
                    // 两个都是 null，那么这两个子节点就不继续存了
                    //（因为没有子节点）
                    continue;
                }

                if ((L == null && R != null) || (L != null && R == null)) {
                    return false;
                }

                if (L.val != R.val) {
                    return false;
                }

                // 当前节点是对称的，继续存子节点进一步判断子节点是否对称
                // 左的左和右的右配对
                queue.offer(L.left);
                queue.offer(R.right);
                // 右的右和左的左配对
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