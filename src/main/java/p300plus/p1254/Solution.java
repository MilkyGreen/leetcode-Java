package p300plus.p1254;

public class Solution {
    int[][] ds = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int row;
    int col;
    public int closedIsland(int[][] grid) {
        int ret = 0;
        row = grid.length;
        col = grid[0].length;

        for(int j = 0;j< col;j++){
            changeZero(grid,0,j);
            changeZero(grid,row-1,j);
        }

        for(int i = 0;i< row;i++){
            changeZero(grid,i,0);
            changeZero(grid,i,col-1);
        }

        for(int i = 1;i < row-1;i++){
            for(int j = 1;j < col-1;j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j);
                    ret++;
                }
            }
        }
        return ret;
    }

    private void changeZero(int[][] grid,int i,int j){
        if(i < 0 || i == row || j < 0 || j == col){
            return;
        }

        if(grid[i][j] == 0){
            grid[i][j] = 1;
            for(int[] d : ds){
                changeZero(grid,i + d[0],j + d[1]);
            }
        }
    }

    private void dfs(int[][] grid,int i,int j){
        if(grid[i][j] == 0){
            
            grid[i][j] = 1;
            for(int[] d : ds){
                dfs(grid,i + d[0],j + d[1]);
            }
        }
    }
}
