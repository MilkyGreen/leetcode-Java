package p300plus.p547;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Map<Integer,List<Integer>> edges = new HashMap<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(isConnected[i][j] == 1){
                    List<Integer> iList = edges.getOrDefault(i,new ArrayList<>());
                    iList.add(j);
                    edges.put(i,iList);

                    List<Integer> jList = edges.getOrDefault(j,new ArrayList<>());
                    jList.add(i);
                    edges.put(j,jList);
                }
            }
        }
        int ret = 0;
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                ret++;
                dfs(edges,visited,i);
            }
        }
        return ret;
    }

    private void dfs(Map<Integer,List<Integer>> edges,boolean[] visited,int i){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        List<Integer> edge = edges.get(i);
        if(edge == null || edge.size() == 0){
            return;
        }
        for(int e : edge){
            dfs(edges,visited,e);
        }
    }
}
