package p100.p59;

/**
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int curr = 1;
        int layerCount = n;
        int layer = 0;
        int max = n * n;
        while(layerCount > 0){
            for(int i = 0;i < layerCount-1;i++){
                res[layer][(i+layer)] = curr;
                curr++;
            }

            for(int i = 0;i < layerCount-1;i++){
                res[(i+layer)][n-layer-1] = curr;
                curr++;
            }

            for(int i = 0;i < layerCount-1;i++){
                res[n-layer-1][n-(i+layer)-1] = curr;
                curr++;
            }

            for(int i = 0;i < layerCount-1;i++){
                res[n-(i+layer)-1][layer] = curr;
                curr++;
            }
            layerCount -= 2;
            layer++;
        }
        if(n % 2 != 0){
            res[n/2][n/2] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().generateMatrix(4);
    }

}
