package p300plus.p1268;


public class Solution2 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.findPrefixNode(prefix));
        }
        return result;
    }
}

class Trie{

    class Node{
        public Node[] children = new Node[26];
        public boolean isEnd = false;
        public String s = null;
    }

    public Node root;
    
    public Trie(){
        root = new Node();
    }

    void insert(String word){
        int len = word.length();
        Node curr = root;
        for(int i = 0;i < len;i++){
            char c = word.charAt(i);
            Node[] children = curr.children;
            if(children[c - 'a'] == null){
                children[c - 'a'] = new Node();
            }
            curr = children[c - 'a'];
        }
        curr.isEnd = true;
        curr.s = word;
    }

    List<String> findPrefixNode(String prefix){
        Node curr = root;
        for(char c : prefix.toCharArray()){
            Node[] children = curr.children;
            if(children[c - 'a'] == null){
                return new ArrayList<>();
            }
            curr = children[c - 'a'];
        }
        List<String> ret = new ArrayList<>();
        searchWordWithPrefixNode(curr,ret);
        return ret;
    }

    
    void searchWordWithPrefixNode(Node prefixNode,List<String> ret){
        
        if(ret.size() == 3){
            return;
        }
        if(prefixNode.isEnd){
            ret.add(prefixNode.s);
        }
        for(int i = 0;i < 26;i++){
            if(prefixNode.children[i] != null){
                searchWordWithPrefixNode(prefixNode.children[i],ret);
            }
        }
    }




}