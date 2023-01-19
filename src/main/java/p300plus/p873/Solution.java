package p300plus.p873;

public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int ret = 0;
        Map<Integer,Integer> index = new HashMap<>();
        int n = arr.length;
        for(int i = 0;i < n;i++){
            index.put(arr[i],i);
        }
        int[][] dp = new int[n][n];

        for(int k = 0;k < n;k++){
            for(int j = 0;j < k;j++){
                int i = index.getOrDefault(arr[k] - arr[j],-1);
                if(i >= 0 && i < j){
                    int dis = (dp[i][j] > 0 ? dp[i][j] : 2) + 1;
                    dp[j][k] = dis;
                    ret = Math.max(ret,dis);
                }
            }
        }
        return ret > 2 ? ret : 0;
    }
}
