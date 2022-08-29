package p300plus.p1293;

public class Solution {
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        if(row == 1 && col == 1){
            return 0;
        }

        int[][] ds = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[row][col][k+1];
        queue.addLast(new int[]{0,0,k});
        int step = 0;

        while(queue.size() > 0){
            int size = queue.size();
            step++;
            for(int i = 0;i < size;i++){
                int[] curr = queue.removeFirst();
                for(int[] d : ds){
                    int nr = d[0] + curr[0];
                    int nc = d[1] + curr[1];
                    int nk = curr[2];
                    if(nr >= 0 && nr < row && nc >= 0 && nc < col){
                        if(grid[nr][nc] == 0 && !visited[nr][nc][nk]){
                            if(nr == row - 1 && nc == col - 1){
                                return step;
                            }else{
                                visited[nr][nc][nk] = true;
                                queue.addLast(new int[]{nr,nc,nk});
                            }
                        }else if(grid[nr][nc] == 1 && nk >= 1 && !visited[nr][nc][nk-1]){
                            visited[nr][nc][nk-1] = true;
                            queue.addLast(new int[]{nr,nc,nk-1});
                        }
                    }
                }
            }
            
        }
        return -1;
    }
}
