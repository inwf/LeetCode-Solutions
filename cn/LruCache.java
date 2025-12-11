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
        // 先学标准库
        // 二刷的时候再看双向链表
        // 参考：https://leetcode.cn/problems/lru-cache/solutions/2456294/tu-jie-yi-zhang-tu-miao-dong-lrupythonja-czgt/?envType=study-plan-v2&envId=top-100-liked
        // LinkedHashMap 插入在右边，所以最左边的是最老的
        Map<Integer, Integer> cache = new LinkedHashMap<>();
        int capacity = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = cache.get(key);
            // 根据返回值判断是否在缓存中
            if (value != null) {
                // 在缓存中
                // 刷新一下缓存
                put(key, value);
                return value;
            }

            // 不在缓存中
            return -1;
        }

        public void put(int key, int value) {
            // 因为这里使用的是 LinkedHashMap，它默认保持插入顺序（accessOrder = false）
            // 每次访问元素时（get或put），代码都会先 remove 再 put，这样最近使用的元素会被移到链表末尾
            Integer temp = cache.remove(key);
            // 根据返回值判断是否在缓存中
            if (temp != null) {
                // 在缓存中
                cache.put(key, value);
                return;
            }

            // 不在缓存中
            // 判断缓存是否已满
            if (cache.size() >= capacity) {
                // 满了
                Integer oldest = cache.keySet().iterator().next();
                cache.remove(oldest);
                cache.put(key, value);
                return;
            }

            // 没满
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