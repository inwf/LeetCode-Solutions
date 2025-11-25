package leetcode.editor.cn;

import leetcode.editor.common.*;

/**
 * 538 把二叉搜索树转换为累加树
 * 2025-11-25 17:30:54
 * inwf
 */

public class ConvertBstToGreaterTree {

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
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            // 累加树：当前节点的值 = 比自己大的节点的值之和 + 自己本身的值
            // 参考：https://www.programmercarl.com/0538.%E6%8A%8A%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E8%BD%AC%E6%8D%A2%E4%B8%BA%E7%B4%AF%E5%8A%A0%E6%A0%91.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
            // 因为是二叉搜索树，逆中序遍历即可： 右 -> 中 -> 左 ->
            dfs(root);
            return root;
        }

        public void dfs(TreeNode cur) {
            if (cur == null) {
                return;
            }

            // 右
            dfs(cur.right);

            // 中
            sum += cur.val;
            cur.val = sum;

            // 左
            dfs(cur.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        // put your test code here
        // solution.
    }
}