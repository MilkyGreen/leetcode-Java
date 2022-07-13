package p300plus.p429;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        List<Node> list = new ArrayList<>();
        list.add(root);

        while(list.size() > 0){

            List<Integer> intLine = new ArrayList<>();
            
            List<Node> line = new ArrayList<>();
            intLine = new ArrayList<>();
            for(Node node : list){
                intLine.add(node.val);
                List<Node> children = node.children;
                for(Node child : children){
                    line.add(child);
                }
            }
            ret.add(intLine);
            list = line;
        }
        return ret;
    }
}
