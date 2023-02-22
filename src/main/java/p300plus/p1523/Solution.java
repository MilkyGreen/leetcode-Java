public class Solution {
    public int countOdds(int low, int high) {
        int ret = 0;
        int count = high - low + 1;
        if(low % 2 == 0){
            count--;
        }
        if(high % 2 != 0){
            ret++;
            count--;
        }
        return ret + count/2;
    }
}
