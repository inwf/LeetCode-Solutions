package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 349 两个数组的交集
 * 2025-11-19 14:38:02
 * inwf
 */

public class IntersectionOfTwoArrays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> st = new HashSet<>();
            Set<Integer> ans = new HashSet<>();

            for (int i : nums1) {
                st.add(i);
            }

            for (int i : nums2) {
                if (st.contains(i)) {
                    ans.add(i);
                }
            }

            int[] ret = new int[ans.size()];
            int i = 0;
            for (int x : ans) {
                ret[i++] = x;
            }
            return ret;

            // 下面两个方法都可以
//            return ans.stream().mapToInt(Integer::valueOf).toArray();
//            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        // put your test code here
        // solution.
    }
}