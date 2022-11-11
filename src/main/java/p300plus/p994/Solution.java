package p300plus.p994;

public class Solution {
    LinkedList<int[]> rotteds = new LinkedList<>();
    int total = 0;
    int rottedNum = 0;
    int[][] grid;
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] != 0){
                    total++;
                    if(grid[i][j] == 2){
                        rottedNum++;
                        rotteds.addLast(new int[]{i,j});
                    }
                }
            }
        }
        int[][] ds = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int minutes = 0;
        int newRotted = 0;
        while(total != rottedNum){
            
            newRotted = 0;
            minutes++;
            int size = rotteds.size();
            for(int i = 0;i < size;i++){
                int[] ra = rotteds.removeFirst();
                int row = ra[0];
                int col = ra[1];

                for(int[] d : ds){
                    int newRow = row + d[0];
                    int newCol = col + d[1];
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        newRotted++;
                        rotteds.addLast(new int[]{newRow,newCol});
                    }
                }
            }
            
            if(newRotted == 0 && total != rottedNum){
                return -1;
            }

            rottedNum += newRotted;
        }

        return minutes;

    }
}
