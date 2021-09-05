package weekcontest.NO60;

import p100.p0040.Solution22;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 */
public class Solution2 {

    public static void main(String[] args) {
        int[][] land = new int[][]{{1,0,0},{0,1,1},{0,1,1}};
        new Solution2().findFarmland(land);
    }

    List<int[]> res = new ArrayList<>();
    int m;
    int n;
    int[][] land;

    public int[][] findFarmland(int[][] land) {
        this.land = land;
        this.m = land.length;
        this.n = land[0].length;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(this.land[i][j] == 1){
                    res.add(dealFarm(i,j));
                }
            }
        }
        int[][] farms = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            farms[i] = res.get(i);
        }
        return farms;
    }

    int[] dealFarm(int i,int j){

        int[] ans = new int[4];
        ans[0]=i;
        ans[1]=j;
        ans[2]=i;
        ans[3]=j;
        int width = j;
        int depth = i;
        for(;width<n;width++){
            if(land[i][width] != 1){
                break;
            }
        }
        width--;

        for(;depth<m;depth++){
            if(land[depth][j] != 1){
                break;
            }
        }
        depth--;

        ans[2]=depth;
        ans[3]=width;

        for(;i<=depth;i++){
            for(int k=j;k<=width;k++){
                land[i][k] = 2;
            }
        }
        return ans;
    }
}
