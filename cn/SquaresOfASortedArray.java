package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 977 有序数组的平方
 * 2025-11-17 18:47:59
 * inwf
 */

public class SquaresOfASortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];

            int l=0;
            int r=n-1;
            int idx=n-1;
            while(l<=r){
                if (nums[l]*nums[l]>nums[r]*nums[r]){
                    ans[idx--] = nums[l]*nums[l];
                    l++;
                }else {
                    ans[idx--] = nums[r]*nums[r];
                    r--;
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        // put your test code here
        // solution.
    }
}