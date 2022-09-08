package p300plus.p785;

public class Solution {
    int[] marks;
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        marks = new int[len]; // 0 unvisit ,1 a ,2 b.
        for(int i = 0;i < graph.length;i++){
            if(marks[i] == 0 && graph[i].length != 0){
                if(!dfs(graph,i,true)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int[][] graph,int idx,boolean isA){
        if(marks[idx] == 1){
            return isA ? true : false;
        }
        if(marks[idx] == 2){
            return isA ? false : true;
        }
        int[] g = graph[idx];
        marks[idx] = isA ? 1 : 2;
        for(int i : g){
            if(!dfs(graph,i,!isA)){
                return false;
            }
        }
        return true;
    }
}
