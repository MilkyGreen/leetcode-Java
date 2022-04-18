package p100.p59;

public class Solution2 {
    // 模拟四个边遍历，遇到边界或者遍历过的就转向，直到达到n*n
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        boolean[][] v = new boolean[n][n];
        int num = 1;
        int i = 0;
        int j = -1;
        while(true){
            if(num > n * n){
                break;
            }
            j++;
            while(j < n && !v[i][j]){
                ret[i][j] = num++;
                v[i][j] = true;
                j++;
            }
            j--;

            i++;
            while(i < n && !v[i][j]){
                ret[i][j] = num++;
                v[i][j] = true;
                i++;
            }
            i--;

            j--;
            while(j >= 0 && !v[i][j]){
                ret[i][j] = num++;
                v[i][j] = true;
                j--;
            }
            j++;

            i--;
            while(i >= 0 && !v[i][j]){
                ret[i][j] = num++;
                v[i][j] = true;
                i--;
            }
            i++;
        }
        return ret;
    }
}
