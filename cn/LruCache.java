package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 146 LRU 缓存
 * 2025-12-11 23:42:28
 * inwf
 */

public class LruCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        // 不用看双向链表，直接用 ListedHashMap 存 cache 即可
        // get 的时候刷新一下
        // put 的时候先删再 put
        // 注意 put 要判断容量

        private int capacity = 0;
        Map<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            // get 的时候刷新一下顺序
            Integer val = cache.get(key);
            if (val != null) {
                // 在缓存中，刷新一下顺序
                // 注意：是调用本类的 put 函数，而不是 cahce.put()
                put(key, val);
                return val;
            }

            return -1;
        }

        public void put(int key, int value) {
            // 先删再 put
            Integer temp = cache.remove(key);
            if (temp != null) {
                // 在缓存中
                cache.put(key, value);
                return;
            }

            // 不在缓存中，判断容量
            if (cache.size() >= capacity) {
                // LRU
                Integer oldest = cache.keySet().iterator().next();
                cache.remove(oldest);
                cache.put(key, value);
                return;
            }

            cache.put(key, value);
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
//        Solution solution = new LruCache().new Solution();
        // put your test code here
        // solution.
    }
}