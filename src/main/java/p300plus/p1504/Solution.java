package p300plus.p1504;

public class Solution {
    int ret = 0;
    int[][] mat;
    int m;
    int n;
    public int numSubmat(int[][] mat) {
        this.mat = mat;
        this.m = mat.length;
        this.n = mat[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] == 1){
                    numAt(i,j);
                }
            }
        }
        return ret;
    }

    private void numAt(int i,int j){
        int colEnd = j;
        while(colEnd < n && mat[i][colEnd] == 1){
            ret++;
            int currRow = i+1;
            while(currRow < m && nextLineAllOne(currRow,j,colEnd)){
                ret++;
                currRow++;
            }
            colEnd++;
        }
    }

    private boolean nextLineAllOne(int row,int colStart,int colEnd){
        for(int i = colStart;i <= colEnd;i++){
            if(mat[row][i] != 1){
                return false;
            }
        }
        return true;
    }
}
