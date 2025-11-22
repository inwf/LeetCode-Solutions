package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 111 二叉树的最小深度
 * 2025-11-22 17:14:33
 * inwf
 */

public class MinimumDepthOfBinaryTree {

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
        public int minDepth(TreeNode root) {
            // 某个节点没有子节点了，说明是叶子节点，可以记录当前深度
            return bfs(root);
        }

        public int bfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int dep = 0;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

//            int ans = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                // 能进来说明当前层有节点
                // 不然进不了 while 循环
                int n = queue.size();
                dep++;
                for (int i = 0; i < n; i++) {
                    TreeNode cur = queue.poll();

                    if (cur.left!=null){
                        queue.offer(cur.left);
                    }
                    if (cur.right!=null){
                        queue.offer(cur.right);
                    }

                    if (cur.left==null&&cur.right==null){
                        // 当前节点是叶子节点
//                        ans=Math.min(ans,dep);
                        // 直接返回第一个叶子节点深度即可
                        return dep;
                    }
                }
            }

            return dep;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        // put your test code here
        // solution.
    }
}