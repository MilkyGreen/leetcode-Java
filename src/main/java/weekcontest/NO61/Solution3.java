package weekcontest.NO61;

import java.util.Arrays;

/**
 * <p>
 */
public class Solution3 {

    //10
    //{{9,10,2},{4,5,6},{6,8,1},{1,5,5},{4,9,5},{1,6,5},{4,8,3},{4,7,10},{1,9,8},{2,3,5}}

    public static void main(String[] args) {
        int n = 10;
        int[][] rs = new int[][]{{9,10,2},{4,5,6},{6,8,1},{1,5,5},{4,9,5},{1,6,5},{4,8,3},{4,7,10},{1,9,8},{2,3,5}};

        System.out.println(new Solution3().maxTaxiEarnings(n,rs));
    }


    public long maxTaxiEarnings(int n, int[][] rides) {
        long max = 0;
        long[] f = new long[n+1];
        f[0] = 0;
        f[1] = 0;
        Arrays.sort(rides,(o1,o2) -> o1[1] - o2[1]);
        for(int[] r : rides){
            int start = r[0];
            int end = r[1];
            int tip = r[2];
            int i = start;
            while(i >0 && f[i] == 0){
                i--;
            }
            f[end] = Math.max(max,f[i] + (end - start + tip));
            max = Math.max(max,f[end]);
        }
        return max;
    }
}
