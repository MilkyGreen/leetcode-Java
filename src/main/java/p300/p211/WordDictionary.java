package p300.p211;

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        char[] cs = word.toCharArray();
        for(int i = 0; i < word.length();i++){
            int idx = cs[i] - 'a';
            if(node.nodes[idx] == null){
                node.nodes[idx] = new Node();
            }
            node = node.nodes[idx];
            if(i == word.length() - 1){
                node.isEnd = true;
            }
        }
    }
    
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        return search(cs,0,root);
    }

    private boolean search(char[] cs,int idx,Node node){
        if(node == null){
            return false;
        }
        if(idx >= cs.length){
            return node.isEnd;
        }
        for(int i = idx;i < cs.length;i++){
            if(cs[i] != '.'){
                int j = cs[i] - 'a';
                if(node.nodes[j] == null){
                    return false;
                }
                node = node.nodes[j];
            }else{
                for(Node n : node.nodes){
                    if(search(cs,i+1,n)){
                        return true;
                    }
                }
                return false;
            }
        }
        return node.isEnd;
    }
}

class Node{
    Node[] nodes = new Node[26];
    boolean isEnd = false;
}
