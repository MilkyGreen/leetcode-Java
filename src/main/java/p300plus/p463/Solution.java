package p300plus.p463;

public class Solution {
    int[][] ds = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int islandPerimeter(int[][] grid) {
        int ret = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] == 1){
                    for(int[] d : ds){
                        if(isIslandEdge(grid,i,j,d)){
                            ret++;
                        }
                    }
                }

            }
        }
        return ret;
    }

    boolean isIslandEdge(int[][] grid,int i,int j,int[] d){
        int newRow = i + d[0];
        int newCol = j + d[1];
        if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == 0){
            return true;
        }
        return false;
    }
}
