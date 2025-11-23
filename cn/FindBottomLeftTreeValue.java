package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 513 找树左下角的值
 * 2025-11-23 16:42:41
 * inwf
 */

public class FindBottomLeftTreeValue {

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
        TreeNode cur;

        public int findBottomLeftValue(TreeNode root) {
            // BFS 即可,每次节点从右往左放,这样最后放的就是最左下角的节点了
            bfs(root);
            return cur.val;
        }

        public void bfs(TreeNode root) {
            // 其实不用判断,因为题意说了节点个数 >= 1
            if (root == null) {
                return;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                root = queue.poll();
                // 这里取出节点,直到最后一个节点
                cur = root;

                if (root.right != null) {
                    queue.offer(root.right);
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
        // put your test code here
        // solution.
    }
}