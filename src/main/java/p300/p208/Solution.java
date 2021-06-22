package p300.p208;

import java.util.ArrayList;
import java.util.List;

/**请你实现 Trie 类：

 Trie() 初始化前缀树对象。
 void insert(String word) 向前缀树中插入字符串 word 。
 boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Solution {

    public static class Trie {

        List<Trie> children;
        char value;
        boolean isEnd = false;
        /** Initialize your data structure here. */
        public Trie() {
            children = new ArrayList<Trie>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            List<Trie> list;
            Trie next = this;
            int l = word.length();
            for (int i = 0; i < word.length(); i++) {
                boolean isEnd = i ==  l - 1;
                list = next.children;
                if (list.size() == 0){
                    next = new Trie();
                    next.value = word.charAt(i);
                    next.isEnd = isEnd;
                    list.add(next);
                }else{
                    boolean found = false;
                    for (Trie trie : list) {
                        if(trie.value == word.charAt(i)){
                            if(isEnd){
                                trie.isEnd = true;
                            }
                            next = trie;
                            found = true;
                            break;
                        }
                    }
                    if (!found){
                        next = new Trie();
                        next.value = word.charAt(i);
                        next.isEnd = isEnd;
                        list.add(next);
                    }
                }
            }

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = this;
            int l = word.length();
            for (int i = 0; i < word.length(); i++) {
                boolean isEnd = i ==  l - 1;
                List<Trie> list = node.children;
                boolean found = false;
                if (list.size() == 0){
                    return false;
                }else{
                    for (Trie trie : list) {
                        if(trie.value == word.charAt(i)){
                            if (isEnd){
                                return trie.isEnd;
                            }
                            node = trie;
                            found = true;
                            break;
                        }
                    }
                    if (!found){
                        return false;
                    }
                }
            }
            return true;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = this;
            if (node.children.size() == 0){return false;}
            for (int i = 0; i < prefix.length(); i++) {
                List<Trie> list = node.children;
                boolean found = false;
                if(list.size() == 0){return false;}
                for (Trie trie2 : list) {
                    if (trie2.value == prefix.charAt(i)){
                        node = trie2;
                        found = true;
                        break;
                    }
                }
                if (!found) {return false;}
            }
            return true;
        }
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
