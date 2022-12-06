package p300plus.p310;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        if(edges == null || edges.length == 0){
            for(int i = 0;i < n;i++){
                ret.add(i);
            }
            return ret;
        }
        List<Set<Integer>> edgeList = new ArrayList<>();
        for(int i =0;i < n;i++){
            edgeList.add(new HashSet<>());
        }
        for(int[] e : edges){
            edgeList.get(e[0]).add(e[1]);
            edgeList.get(e[1]).add(e[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0;i < edgeList.size();i++){
            Set<Integer> set = edgeList.get(i);
            if(set.size() == 1){
                queue.offer(i);
            }
        }
        int remaining = n;
        while(remaining > 2){
            int size = queue.size();
            remaining -= size;
            for(int i = 0;i < size;i++){
                int a = queue.poll();
                Set<Integer> bSet = edgeList.get(a);
                int b = bSet.iterator().next();
                edgeList.get(b).remove(a);
                if(edgeList.get(b).size() == 1){
                    queue.offer(b);
                }
            }
        }
        return queue;
    }
}
