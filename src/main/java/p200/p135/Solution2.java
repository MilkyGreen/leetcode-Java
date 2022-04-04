package p200.p135;

import java.util.Arrays;

public class Solution2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 0;
        int[] cs = new int[n];
        Arrays.fill(cs,1);
        for(int i = 1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                cs[i] = cs[i-1]+1;
            }
        }
        for(int i = n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1] && cs[i] <= cs[i+1]){
                cs[i] = cs[i+1] + 1;
            }
        }
        for(Integer c : cs){
            ret += c;
        }
        return ret;
    }
}
