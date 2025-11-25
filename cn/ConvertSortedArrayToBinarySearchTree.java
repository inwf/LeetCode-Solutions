package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 108 将有序数组转换为二叉搜索树
 * 2025-11-25 17:12:01
 * inwf
 */

public class ConvertSortedArrayToBinarySearchTree {

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
        public TreeNode sortedArrayToBST(int[] nums) {
            // 要平衡，所以左右两边节点数量尽可能相同
            // 每次二分找到中间节点，这个节点作为根节点
            // 前续遍历即可：中 -> 左 -> 右
            int n = nums.length;
            return dfs(nums, 0, n - 1);
        }

        // 左闭右闭 while(l <= r)
        public TreeNode dfs(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = left + (right - left) / 2;
            TreeNode cur = new TreeNode(nums[mid]);
            cur.left = dfs(nums, left, mid - 1);
            cur.right = dfs(nums, mid + 1, right);

            return cur;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        // put your test code here
        // solution.
    }
}