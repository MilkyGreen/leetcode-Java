class MapSum {

    Trie trie;
    Map<String,Integer> map;

    public MapSum() {
        trie = new Trie();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int oldVal = map.getOrDefault(key,0);
        map.put(key,val);
        trie.insert(key, val,oldVal);
    }
    
    public int sum(String prefix) {
        Node node = trie.getByPrefix(prefix);
        if(node != null){
            return node.val;
        }else{
            return 0;
        }
    }

    class Trie{
        Node root = new Node();

        public void insert(String key,int val,int oldVal){
            Node[] nodes = root.children;
            for(char c : key.toCharArray()){

                Node node = nodes[c - 'a'];
                if(node == null){
                    node = new Node();
                    nodes[c - 'a'] = node;
                }
                node.val += val;
                node.val -= oldVal;

                nodes = node.children;
            }
        }

        public Node getByPrefix(String prifix){
            Node[] nodes = root.children;
            char[] cs = prifix.toCharArray();
            int len = cs.length;
            for(int i = 0;i < len;i++){
                char c = cs[i];
                Node node = nodes[c - 'a'];
                if(node == null){
                    return null;
                }
                if(i == len - 1){
                    return node;
                }
                nodes = node.children;
            }
            return null;
        }
    }

    class Node{
        Node[] children = new Node[26];
        int val = 0;
    }
}