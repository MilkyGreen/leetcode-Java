package p300plus.p329;

public class Solution {
    int ret = 1;
    int[][] matrix;
    boolean[][] visited;
    int row;
    int col;
    int[][] ds = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
        visited = new boolean[row][col];
        cache = new int[row][col][1];
        for(int i = 0;i < row;i++){
            for(int j = 0;j< col;j++){
                if(isMini(i, j)){
                    ret = Math.max(ret,dfs(i,j,matrix[i][j],true));
                }
            }
        }
        return ret;
    }

    int dfs(int i,int j,int num,boolean start){
        if(i < 0 || i >= row || j < 0 || j >= col || visited[i][j] ){
            return 0;
        }
        
        int maxLen = 0;
        if(start || matrix[i][j] > num){
            if(cache[i][j][0] != 0){
                return cache[i][j][0];
            }
            visited[i][j] = true;
            for(int[] d : ds){
                maxLen = Math.max(maxLen,dfs(i+d[0], j+d[1], matrix[i][j],false) + 1);
            }
            visited[i][j] = false;
            cache[i][j][0] = maxLen;
        }
        return maxLen;
    }

    boolean isMini(int i,int j){
        int n = this.matrix[i][j];
        for(int[] d : ds){
            int newi = i + d[0];
            int newj = j + d[1];
            if(newi >= 0 && newi < this.row && newj >= 0 && newj < this.col){
                if(matrix[newi][newj] < n){
                    return false;
                }
            }
        }
        return true;
    }
}
