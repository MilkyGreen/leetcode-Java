package p0048;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/4/2 23:39
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 翻转每一行
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if(j <= (l - 1)/2){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][l - 1 - j];
                    matrix[i][l - 1 - j] = tmp;
                }
            }
        }
    }

}
