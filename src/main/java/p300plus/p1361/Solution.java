public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer,Integer> parentMap = new HashMap<>();
        for(int i = 0;i < n;i++){
            int left = leftChild[i];
            int right = rightChild[i];
            if(left != -1){
                if(parentMap.containsKey(left)){
                    return false;
                }
                parentMap.put(left,i);

                if(parentMap.containsKey(i) && parentMap.get(i) == left){
                    return false;
                }
            }

            if(right != -1){
                if(parentMap.containsKey(right)){
                    return false;
                }
                parentMap.put(right,i);

                if(parentMap.containsKey(i) && parentMap.get(i) == right){
                    return false;
                }
            }
        }

        Set<Integer> nodes = parentMap.keySet();
        if(nodes.size() != n - 1){
            return false;
        }

        int root = -1;
        for(int i = 0;i < n;i++){
            if(!nodes.contains(i)){
                root = i;
            }
        }

        Set<Integer> seen = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(root);
        seen.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            for(int i =0;i < size;i++){
                int node = queue.removeFirst();
                if(leftChild[node] != -1){
                    int left = leftChild[node];
                    queue.addLast(left);
                    if(seen.contains(left)){
                        return false;
                    }
                    seen.add(left);
                }
                if(rightChild[node] != -1){
                    int right = rightChild[node];
                    queue.addLast(right);
                    if(seen.contains(right)){
                        return false;
                    }
                    seen.add(right);
                }
            }
        }

        return seen.size() == n;
    }
}
