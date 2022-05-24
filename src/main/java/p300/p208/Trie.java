package p300.p208;

public class Trie {
    class Node{
        Node[] words = new Node[26];
        boolean isEnd = false;
    }
    
    Node[] words;

    public Trie() {
        this.words = new Node[26];
    }
    
    public void insert(String word) {
        Node[] curWords = this.words;
        char[] cs = word.toCharArray();
        for(int i = 0;i < word.length();i++){
        
            int idx = cs[i] - 'a';
            Node curNode = curWords[idx];
            if(curNode == null){
                curNode = new Node();
                curWords[idx] = curNode;
            }
            if(i == word.length() - 1){
                curNode.isEnd = true;
            }
            curWords = curNode.words;
        }
    }
    
    public boolean search(String word) {
        Node node = start(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
       return start(prefix) != null;
    }

    public Node start(String prefix){
        Node[] curWords = this.words;
        char[] cs = prefix.toCharArray();
        for(int i = 0;i < prefix.length();i++){
            int idx = cs[i] - 'a';
            Node curNode = curWords[idx];
            if(curNode == null){
                return null;
            }else{
                if(i == prefix.length() - 1){
                    return curNode;
                }else{
                    curWords = curNode.words;
                }
            }
        }
        return null;
    }
}
