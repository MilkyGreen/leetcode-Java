package p300plus.p559;

public class Solution {
    int ret = 0;
    public int maxDepth(Node root) {
        dfs(0,root);
        return ret;
    }

    void dfs(int depth,Node root){
        if(root != null){
            depth++;
            ret = Math.max(ret,depth);
        }else{
            return;
        }
        List<Node> nodes = root.children;
        if(nodes != null && nodes.size() > 0){
            for(Node node : nodes){
                dfs(depth,node);
            }
        }
    }
}
