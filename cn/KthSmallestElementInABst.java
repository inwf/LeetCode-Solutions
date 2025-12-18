package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 230 二叉搜索树中第 K 小的元素
 * 2025-12-02 12:29:41
 * inwf
 */

public class KthSmallestElementInABst {

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
        int cnt = 0;
        int ans = -1;

        public int kthSmallest(TreeNode root, int k) {
            // 二叉搜索树：第 k 小就是中序遍历第 k 个
            dfs(root, k);
            return ans;
        }

        public void dfs(TreeNode cur, int k) {
            if (cur == null) {
                return;
            }

            // 左 -> 中 -> 右
            dfs(cur.left, k);

            cnt++;
            if (cnt == k) {
                ans = cur.val;
                return;
            }

            dfs(cur.right, k);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
        // put your test code here
        // solution.
    }
}