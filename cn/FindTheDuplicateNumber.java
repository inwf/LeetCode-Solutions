package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 287 寻找重复数
 * 2025-12-05 15:00:03
 * inwf
 */

public class FindTheDuplicateNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            // 环形链表变式
            // https://leetcode.cn/problems/find-the-duplicate-number/solutions/3797843/yong-ji-huan-shu-li-jie-zuo-fa-tong-142-tkoc2/?envType=study-plan-v2&envId=top-100-liked
            // 不用纠结，题目是精心设计的 1 <= nums[i] <= n
            // 所以从下标 0 进去，不可能走到 nums[i] = i 情况

            int fast = nums[0];
            int slow = nums[0];

            while (true) {
                fast = nums[nums[fast]];
                slow = nums[slow];

                if (fast == slow) {
                    // 相交
                    break;
                }
            }

            int temp = nums[0];
            while (temp != slow) {
                temp = nums[temp];
                slow = nums[slow];
            }

            return temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        // put your test code here
        // solution.
    }
}