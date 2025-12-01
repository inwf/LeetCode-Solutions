package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 543 二叉树的直径
 * 2025-12-01 23:49:06
 * inwf
 */

public class DiameterOfBinaryTree {

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
        int ans = -1;

        public int diameterOfBinaryTree(TreeNode root) {
            // 二叉树的链：（就是当前节点到叶子节点经过的最多边的个数）
            // 发现很多人不了解链：
            // 想象你站在树上的一个节点（比如一根树枝的某个位置），“链” 就是从你脚下的节点出发，向下延伸到最末端叶子的那条最长的 “树枝”。
            // 如果你站的是一片叶子（树枝的最顶端），那这条链就只有你脚下这一个点，长度是 0（因为没有更长的延伸了）。
            // 如果你站的是一个空节点（根本没有这个节点），链长就是 - 1（可以理解为 “不存在” 的标记）。
            // 如果你站的是中间节点，那就要看左、右两个分叉哪个更长，链长就是 “更长的那个分叉的链长 + 1”（加 1 是因为要算上自己这个节点）。
            // dfs 遍历所有点，找出最长链

            dfs(root);
            return ans;
        }

        public int dfs(TreeNode cur) {
            if (cur == null) {
                // 叶子节点的链 = -1（到 null） + 1 = 0
                return -1;
            }

            // 子节点的链 + 1
            // 因为子节点还要经过一条边到当前节点
            int l = dfs(cur.left) + 1;
            int r = dfs(cur.right) + 1;

            ans = Math.max(ans, l + r);
            return Math.max(l, r);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        // put your test code here
        // solution.
    }
}