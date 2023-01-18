package p300plus.p684;

public class Solution {
    int max = 1000;
    int[] parent = new int[max+1];
    public int[] findRedundantConnection(int[][] edges) {

        for(int i = 0;i < max+1;i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            if(buildUnion(edge[0],edge[1])){
                return edge;
            }
        }
        throw new RuntimeException();
    }

    int findParent(int x){
        if(parent[x] == x){
            return x;
        }
        int p = findParent(parent[x]);
        parent[x] = p;
        return p;
    }

    boolean buildUnion(int a,int b){
        int ap = findParent(a);
        int bp = findParent(b);
        if(ap == bp){
            return true;
        }
        parent[ap] = bp;
        return false;
    }
}
