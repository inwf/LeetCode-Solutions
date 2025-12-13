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
            // preorder 的第一个元素是当前的根节点
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            // 因为两个要么都满足要么都不满足，所以题解只判断了一个
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            // 根据前序遍历找出根
            int rootVal = preorder[preStart];
            // 根据中序遍历找出左子树的大小
            int rootIndex = findRootIndex(inorder, rootVal);
            int leftSize = rootIndex - inStart;

            // preStart + 1 是因为 preStart 是根节点，在本次已经找到了
            // 左子树的范围是 preorder[preStart + 1,preStart + leftSize]
            TreeNode left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
            TreeNode right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
            return new TreeNode(rootVal,left,right);
        }

        public int findRootIndex(int[] inorder, int x) {
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