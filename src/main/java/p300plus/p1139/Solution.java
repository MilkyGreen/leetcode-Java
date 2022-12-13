package p300plus.p1139;

public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int[][] top = new int[row][col];
        int[][] left = new int[row][col];

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(i == 0){
                    top[i][j] = grid[i][j];
                }else{
                    top[i][j] = grid[i][j] == 1 ? top[i-1][j] + 1 : 0;
                }

                if(j == 0){
                    left[i][j] = grid[i][j];
                }else{
                    left[i][j] = grid[i][j] == 1 ? left[i][j-1] + 1 : 0;
                }
            }
        }

        for(int len = Math.min(row,col);len > 0;len--){
            for(int i = 0;i <= row - len;i++){
                for(int j = 0;j <= col - len;j++){
                    if(top[i + len - 1][j] >= len 
                    && top[i + len - 1][j + len - 1]  >= len
                    && left[i][j + len - 1] >= len
                    && left[i + len - 1][j + len - 1]  >= len){
                        return len * len;
                    }
                }
            }
        }
        return 0;
    }
}
