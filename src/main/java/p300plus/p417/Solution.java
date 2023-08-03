package p300plus.p417;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] ds = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int m;
    int n;
    boolean[][] pv;
    boolean[][] av;
    List<List<Integer>> res;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        res = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;

        pv = new boolean[m][n];
        av = new boolean[m][n];

        for(int j = 0;j < n;j++){
            dfs(0,j,true,-1);
        }
        for(int i = 0;i < m;i++){
            dfs(i,0,true,-1);
        }

        for(int j = 0;j < n;j++){
            dfs(m-1,j,false,-1);
        }
        for(int i = 0;i < m;i++){
            dfs(i,n-1,false,-1);
        }

        return res;
    }

    private void dfs(int i,int j, boolean fromPac,int pre){
        if(i < 0 || i >= m || j < 0 || j >= n || (fromPac && pv[i][j]) || (!fromPac && av[i][j])){
            return;
        }

        if(heights[i][j] < pre){
            return;
        }

        if(!fromPac && pv[i][j]){
            List<Integer> cell = new ArrayList<>();
            cell.add(i);
            cell.add(j);
            res.add(cell);
        }

        for(int[] d : ds){
            if(fromPac){
                pv[i][j] = true;
            }else{
                av[i][j] = true;
            }
            dfs(i + d[0],j + d[1],fromPac,heights[i][j]);
        }
    }
}
