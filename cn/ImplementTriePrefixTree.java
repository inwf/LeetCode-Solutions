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
        // 就是 26 叉树
        // 内部类：默认 private
        class Node {
            // 默认 26 个 null
            Node[] son = new Node[26];
            boolean end = false;
        }

        // 所有的开始
        Node root;

        public Trie() {
            // 构造函数
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.son[idx] == null) {
                    // 空
                    // 此时 cur.son[idx] 不为空，有 son 和 end，son 里面是 26 个 null
                    cur.son[idx] = new Node();
                }
                cur = cur.son[idx];
            }
            // 插入完这个单词，结尾用 end 表示
            cur.end = true;
        }

        public boolean search(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.son[idx] == null) {
                    return false;
                }
                cur = cur.son[idx];
            }

            // 判断当前节点是不是之前插入单词的某个结尾
            return cur.end;
        }

        // 就是判断 prefix 是不是之前插入的 word 某个前缀
        public boolean startsWith(String prefix) {
            Node cur = root;
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (cur.son[idx] == null) {
                    return false;
                }
                cur = cur.son[idx];
            }

            // 判断当前节点是不是之前插入单词的某个结尾
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