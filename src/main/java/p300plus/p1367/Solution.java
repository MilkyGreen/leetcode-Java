package p300plus.p1367;

public class Solution {
    LinkedList<Integer> list = new LinkedList<>();

    public boolean isSubPath(ListNode head, TreeNode root) {
        
        ListNode node = head;
        while(node != null){
            list.addLast(node.val);
            node = node.next;
        }

        return dfs(root,new LinkedList<Integer>());
    }


    private boolean dfs(TreeNode node,LinkedList<Integer> path){
        if(node != null){
            path.addLast(node.val);
            if(node.val == list.get(list.size()-1) && path.size() >= list.size()){
                if(compareList(path)){
                    return true;
                }
                // System.out.println("path="+printList(path));
            }

            if( dfs(node.left,path) || dfs(node.right,path) ){
                return true;
            }
            
            path.removeLast();
            return false;
        }
        // System.out.println("node = null, path="+printList(path));
        return false;
    }

    private boolean compareList(LinkedList<Integer> path){
        for(int i = list.size() -1,j = path.size() - 1;i >= 0;i--,j--){
            if(!list.get(i).equals(path.get(j))){
                return false;
            }
        }
        return true;
    }
}
