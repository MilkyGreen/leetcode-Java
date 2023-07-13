package p300plus.p861;

public class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0;i < rows;i++){
            if(grid[i][0] == 0){
                for(int j = 0;j < cols;j++){
                    if(grid[i][j] == 0){
                        grid[i][j] = 1;
                    }else{
                        grid[i][j] = 0;
                    }
                }
            }
        }

        for(int j = 1;j < cols;j++){
            int ones = 0;
            for(int i = 0;i < rows;i++){
                if(grid[i][j] == 1){
                    ones++;
                }
            }
            if(ones < (rows - ones)){
                for(int i = 0;i < rows;i++){
                    if(grid[i][j] == 0){
                        grid[i][j] = 1;
                    }else{
                        grid[i][j] = 0;
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0;i < rows;i++){
            int rowVal = 1;
            for(int j = 1;j < cols;j++){
                rowVal = rowVal*2 + grid[i][j];
            }
            res += rowVal;
        }
        return res;
    }
}
