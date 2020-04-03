package p0048;

/**
 * @author liyunmeng
 * @Description: 矩阵旋转90度
 * @Date 2020/4/2 23:39
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int l = matrix.length;
        // 先转置，即：第1行第1列 -> 第1行第1列，第1行第2列 -> 第2行第1列...依次类推
        for (int i = 0; i < l; i++) {
            // j=i，比如第3行要从第3个元素开始，因为第1个已经被第1行的替换过了，第2个被第2行替换过。
            for (int j = i; j < l; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 翻转每一行，从两边开始替换，到中间停止
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
