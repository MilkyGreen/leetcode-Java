package weekcontest.NO59;

/**
 *
 */
public class Solution1 {


    public static void main(String[] args) {
        int[][] m = new int[3][3];
        //[[2,9,3],[5,4,-4],[1,7,1]]
        m[0] = new int[]{-10000,-10000,-10000};
        m[1] = new int[]{-10000,-10000,-10000};
        m[2] = new int[]{-10000,-10000,-10000};
        System.out.println(new Solution1().maxMatrixSum(m));
    }

    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int ans = 0;
        int cnt = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0){
                   cnt++;
                }
                min = Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        if(cnt % 2 == 1){
            ans -= 2L * min;
        }
        return ans;
    }
}
