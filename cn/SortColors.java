package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 75 颜色分类
 * 2025-12-05 14:52:09
 * inwf
 */

public class SortColors {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int p0 = 0;
            int p1 = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                nums[i] = 2;

                if (x<=1){
                    nums[p1++] = 1;
                }

                if (x==0){
                    nums[p0++] = 0;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        // put your test code here
        // solution.
    }
}