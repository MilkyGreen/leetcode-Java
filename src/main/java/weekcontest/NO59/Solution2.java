package weekcontest.NO59;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class Solution2 {


    public static void main(String[] args) {
        int[][] ma = new int[2][2];
        ma[0] = new int[]{3,5};
        ma[1] = new int[]{5,10};
        new Solution2().minimizeTheDifference(ma,47);
    }

    int ans = Integer.MAX_VALUE;
    int[][] mat;
    int target;
    public int minimizeTheDifference(int[][] mat, int target) {
        int row = mat.length;
        int col = mat[0].length;
        this.mat = mat;
        this.target = target;
        dfs(0,0);
        return ans;
    }

    public void dfs(int row,int sum){
        if(row == mat.length){
            ans = Math.min(ans,Math.abs(sum - target));
            return;
        }
        if(Math.abs(sum - target) > ans){
            return;
        }
        int[] ints = mat[row];
        for (int anInt : ints) {
            dfs(row + 1,sum+anInt);
        }
    }
}
