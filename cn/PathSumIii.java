package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 437 路径总和 III
 * 2025-12-02 15:33:22
 * inwf
 */

public class PathSumIii {

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
        Map<Long, Integer> map = new HashMap<>();
        int ans = 0;

        public int pathSum(TreeNode root, int targetSum) {
            // 参考灵神
            // 枚举路径的终点，统计有多少个起点
            // 树上前缀和
            map.put(0L, 1);
            dfs(root, targetSum, 0L);
            return ans;
        }

        public void dfs(TreeNode cur, int targetSum, Long sum) {
            if (cur == null) {
                return;
            }

            // 选择 cur 节点，所以前缀和要 + cur.val
            sum += cur.val;
            ans += map.getOrDefault(sum - targetSum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

            // 进入选择 cur.left 或 cur.right 后的 dfs
            dfs(cur.left, targetSum, sum);
            dfs(cur.right, targetSum, sum);

            // 恢复现场（这里肯定有 sum，所以直接 get 即可）
            map.put(sum, map.get(sum) - 1);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        // put your test code here
        // solution.
    }
}