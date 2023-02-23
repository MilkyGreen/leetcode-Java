package p300plus.p1110;

public class Solution {
    List<TreeNode> ret = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        for(int n : to_delete){
            set.add(n);
        }
        delete(root,null,false);
        return ret;
    }

    void delete(TreeNode node,TreeNode parent,boolean isLeft){
        if(node == null){
            return;
        }
        if(set.contains(node.val)){
            if(parent != null){
                if(isLeft){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
            delete(node.left,null,true);
            delete(node.right,null,false);
        }else{
            if(parent == null){
                ret.add(node);
            }
            delete(node.left,node,true);
            delete(node.right,node,false);
        }
    }
}
