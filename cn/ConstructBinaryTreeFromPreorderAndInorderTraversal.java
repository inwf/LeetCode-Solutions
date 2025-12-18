package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 105 从前序与中序遍历序列构造二叉树
 * 2025-12-13 12:51:13
 * inwf
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 参考：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/2646359/tu-jie-cong-on2-dao-onpythonjavacgojsrus-aob8/?envType=study-plan-v2&envId=top-100-liked
            // 参考：https://www.bilibili.com/video/BV1XAYke2ETp/
            // 左闭右闭
            // 先从前序找出根（第一个），中序根左边的是左子树，根右边的是右子树
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            // 通过前序找出根节点
            int rootVal = preorder[preStart];
            int rootIndex = findIndex(rootVal, inorder);
            int leftSize = rootIndex - inStart;

            // cur 是根节点
            TreeNode cur = new TreeNode(rootVal);
            cur.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
            cur.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
            return cur;
        }

        public int findIndex(int x, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == x) {
                    return i;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // put your test code here
        // solution.
    }
}