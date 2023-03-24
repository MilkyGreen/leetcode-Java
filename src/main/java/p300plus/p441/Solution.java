package p300plus.p441;

public class Solution {
    public int arrangeCoins(int n) {
        
        int ret = 0;
        int row = 1;
        while(n >= row){
            
            n -= row;
            ret++;
            row++;
        }
        return ret;
    }
}
