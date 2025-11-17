package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 704 二分查找
 * 2025-11-17 18:29:54
 * inwf
 */

public class BinarySearch {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid]>target){
                    r=mid-1;
                }else if (nums[mid]<target){
                    l=mid+1;
                }else {
                    return mid;
                }
            }
            // 没找到
            return -1;
        }
        // l  mid  r
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // put your test code here
        // solution.
    }
}