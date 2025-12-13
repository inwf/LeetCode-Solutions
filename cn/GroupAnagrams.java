package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 49 字母异位词分组
 * 2025-12-13 20:45:46
 * inwf
 */

public class GroupAnagrams {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 先排序，再 add
            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }

            return new ArrayList<>(map.values());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // put your test code here
        // solution.
    }
}