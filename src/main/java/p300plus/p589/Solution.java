package p300plus.p589;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();

        LinkedList<Node> dqueue = new LinkedList<>();
        dqueue.addFirst(root);
        while(dqueue.size() > 0){
            Node node = dqueue.removeFirst();
            if(node != null){
                res.add(node.val);
                List<Node> children = node.children;
                if(children != null && children.size() > 0){
                    for(int i = children.size()-1; i>= 0;i--){
                        dqueue.addFirst(children.get(i));
                    }
                }
            }
        }

        return res;
    }
}
