package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 501 二叉搜索树中的众数
 * 2025-11-24 21:04:01
 * inwf
 */

public class FindModeInBinarySearchTree {

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

        List<Integer> ans = new ArrayList<>();
        int cnt = 1;
        int maxCnt = 0;
        Integer pre = null;

        public int[] findMode(TreeNode root) {
            // 二叉搜索树：中序遍历
            dfs(root);

            int n = ans.size();
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = ans.get(i);
            }

            return ret;
        }

        public void dfs(TreeNode cur) {
            if (cur == null) {
                return;
            }

            // 左
            dfs(cur.left);

            // 中
            if (pre == null || pre != cur.val) {
                cnt = 1;
            } else {
                cnt++;
            }

            if (cnt > maxCnt) {
                // 找到了数量更多的数字了，清空之前的记录
                ans.clear();
                ans.add(cur.val);
                maxCnt = cnt;
            } else if (cnt == maxCnt) {
                // 找到另一个数量一样的众数
                ans.add(cur.val);
            }

            pre = cur.val;

            // 右
            dfs(cur.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
        // put your test code here
        // solution.
    }
}