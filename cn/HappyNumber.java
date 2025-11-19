package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 202 快乐数
 * 2025-11-19 14:50:55
 * inwf
 */

public class HappyNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {

            Set<Integer> st = new HashSet<>();
            int sum = n;

            while (sum != 1) {
                sum = check(sum);
                if (st.contains(sum)) {
                    // 遇到重复的了
                    return false;
                } else {
                    // 暂时没有重复，加入 st
                    st.add(sum);
                }
            }
            return true;
        }

        public int check(int n) {
            int sum = 0;
            while (n > 0) {
                int temp = n % 10;
                sum += temp * temp;
                n /= 10;
            }

            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        // put your test code here
        // solution.
    }
}