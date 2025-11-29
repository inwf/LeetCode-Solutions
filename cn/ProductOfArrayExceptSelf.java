package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 238 除自身以外数组的乘积
 * 2025-11-29 20:23:24
 * inwf
 */

public class ProductOfArrayExceptSelf {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 前缀积变式
            // l[i] 表示 nums[0...i-1] 之积
            // r[i] 表示 nums[i+1...n-1] 之积
            int n = nums.length;
            int[] l = new int[n];
            int[] r = new int[n];
            int[] ans = new int[n];

            l[0] = 1;
            for (int i = 1; i < n; i++) {
                l[i] = l[i - 1] * nums[i - 1];
            }

            r[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                r[i] = r[i + 1] * nums[i + 1];
            }

            for (int i = 0; i < n; i++) {
                ans[i] = l[i] * r[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        // put your test code here
        // solution.
    }
}