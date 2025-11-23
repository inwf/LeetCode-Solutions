package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 572 另一棵树的子树
 * 2025-11-23 14:05:48
 * inwf
 */

public class SubtreeOfAnotherTree {

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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            // 不要想花里胡哨的，直接暴力遍历 a 树，然后递归判断每个节点作为根的时候是不是和 b 树相同
            // 递归判断是否相同的树：100 相同的树

            /*
            if (root == null) {
                return false;
            }

            return check(root, subRoot)
                    || isSubtree(root.right, subRoot)
                    || isSubtree(root.left, subRoot);
            */
            return bfs(root, subRoot);
        }

        public boolean bfs(TreeNode a, TreeNode b) {
            // 其实不用这个 if,因为题目里说了节点数量 >= 1
            if (a == null) {
                return false;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(a);

            while(!queue.isEmpty()){
                // 每个节点都判断一下是否相等
                TreeNode cur = queue.poll();
                boolean flag = check(cur,b);
                if (flag){
                    return true;
                }

                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            return false;
        }

        public boolean check(TreeNode a, TreeNode b) {
            // 要么都为 null
            if (a == null && b == null) {
                return true;
            }

            // 要么都不为 null 且本身和子节点相等
            if (a != null && b != null && a.val == b.val) {
                return check(a.left, b.left) && check(a.right, b.right);
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        // put your test code here
        // solution.
    }
}