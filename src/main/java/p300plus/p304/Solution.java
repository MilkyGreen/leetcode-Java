package p300plus.p304;

public class Solution {
    int[][] matrix;
    int[][] matrixSums;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int r = matrix.length;
        int c = matrix[0].length;
        matrixSums = new int[r][c+1];
        for(int i = 0;i < r;i++){
            int[] sums = matrixSums[i];
            int sum = 0;
            for(int j = 0;j < c;j++){
                sum += matrix[i][j];
                sums[j+1] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum = 0;
        for(int i = row1;i <= row2;i++){
            int[] sums = matrixSums[i];
            sum += sums[col2+1] - sums[col1];
        }
        return sum;
    }
}
