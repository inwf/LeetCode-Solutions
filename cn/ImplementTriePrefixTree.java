package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

/**
 * 208 实现 Trie (前缀树)
 * 2025-12-11 20:29:14
 * inwf
 */

public class ImplementTriePrefixTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        // 就是 26 叉树，三个函数长得差不多
        // 内部类：默认 private
        class Node { // 每个节点是一个 Node，用下标表示字符，本身不存储 value
            Node[] son = new Node[26]; // 26 个 null
            boolean end = false;
        }

        // 所有的开始
        Node root;

        public Trie() {
            // 构造函数
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root; // 用 cur 来遍历字典树
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.son[idx] == null) {
                    cur.son[idx] = new Node();
                }
                cur = cur.son[idx];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            Node cur = root; // 用 cur 来遍历字典树
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.son[idx] == null) {
                    return false;
                }
                cur = cur.son[idx];
            }
            return cur.end;
        }

        // 就是判断 prefix 是不是之前插入的 word 某个前缀
        public boolean startsWith(String prefix) {
            Node cur = root; // 用 cur 来遍历字典树
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (cur.son[idx] == null) {
                    return false;
                }
                cur = cur.son[idx];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
//        Solution solution = new ImplementTriePrefixTree().new Solution();
        // put your test code here
        // solution.
    }
}