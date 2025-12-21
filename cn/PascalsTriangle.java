package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 118 杨辉三角
 * 2025-12-04 20:28:53
 * inwf
 */

public class PascalsTriangle {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            // 每一行下标从 1 开始，其他地方就是 0
            // 每个位置的值是该位置上面和左上方的值之和
            // 行数范围：[0, numRows]

            List<List<Integer>> ans = new ArrayList<>();
            // 第 0 行
            ans.add(List.of(1));

            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>(i + 1);
                // 每一行第一个是 1
                row.add(1);

                for (int j = 1; j < i; j++) {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }

                // 每一行最后一个是 1
                row.add(1);
                ans.add(row);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        // put your test code here
        // solution.
    }
}