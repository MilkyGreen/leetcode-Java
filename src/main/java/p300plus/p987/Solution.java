package p300plus.p987;

public class Solution {
    TreeMap<Integer,List<TreeNode>> cols = new TreeMap<>();
    Map<TreeNode,Integer> nodeRowMap = new HashMap<>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> ret = new ArrayList<>();
        for(Map.Entry<Integer,List<TreeNode>> e : cols.entrySet()){
            List<TreeNode> colNodes = e.getValue();
            Collections.sort(colNodes, (TreeNode n1,TreeNode n2) -> {
                int n1Row = nodeRowMap.get(n1);
                int n2Row = nodeRowMap.get(n2);
                if(n1Row == n2Row){
                    return n1.val - n2.val;
                }else{
                    return n1Row - n2Row;
                }
            });
            List<Integer> numCol = new ArrayList<>();
            for(TreeNode tn : colNodes){
                numCol.add(tn.val);
            }
            ret.add(numCol);
        }
        return ret;
    }

    void dfs(TreeNode node,int row,int col){
        if(node == null){
            return;
        }
        List<TreeNode> nodes = cols.get(col);
        if(nodes == null){
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        cols.put(col,nodes);
        nodeRowMap.put(node,row);
        dfs(node.left,row+1,col-1);
        dfs(node.right,row+1,col+1);
    }
}
