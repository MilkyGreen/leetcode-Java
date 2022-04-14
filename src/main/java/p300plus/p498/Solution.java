package p300plus.p498;

public class Solution {
    int idx = 0;
    int[] ret;
    int row;
    int col;
    int[][] mat;
    public int[] findDiagonalOrder(int[][] mat) {
        this.mat = mat;
        row = mat.length;
        col = mat[0].length;
        int n = row * col;
        ret = new int[n];
        up(0,0);
        return ret;
    }

    void down(int i,int j){
        while(i < row && j >= 0){
            ret[idx] = mat[i][j];
            idx++;
            i++;
            j--;
        }
        i--;
        j++;
        if(i == row -1 && j == col - 1){
            return;
        }
        if(i == row-1){
            up(i,j+1);
        }else{
            up(i+1,j);
        }
    }

    void up(int i,int j){
        while(i >= 0 && j < col){
            ret[idx] = mat[i][j];
            idx++;
            i--;
            j++;
        }
        i++;
        j--;
        if(i == row -1 && j == col - 1){
            return;
        }
        if(j != col - 1){
            down(i,j+1);
        }else{
            down(i+1,j);
        }
    
    }
}
