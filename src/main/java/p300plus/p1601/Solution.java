package p300plus.p1601;

/**
 * <p>
 */
public class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int l = requests.length;
        int res = 0;
        for(int i = 1;i< (1 << l);i++){
            int[] in = new int[n];
            int[] out = new int[n];
            int idx = 0;
            int state = i;
            int choosed = 0;
            while(state!= 0){
                if((state & 1) == 1){
                    int[] move = requests[idx];
                    in[move[1]] = in[move[1]]+1;
                    out[move[0]] = out[move[0]]+1;
                    choosed++;
                }
                idx++;
                state >>= 1;
            }
            boolean match = true;
            for(int j = 0;j<n;j++){
                if(in[j] != out[j]){
                    match = false;
                    break;
                }
            }
            if(match){
                res = Math.max(res,choosed);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[5][2];
        //[[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
        nums[0] = new int[]{0,1};
        nums[1] = new int[]{1,0};
        nums[2] = new int[]{1,0};
    }
}
