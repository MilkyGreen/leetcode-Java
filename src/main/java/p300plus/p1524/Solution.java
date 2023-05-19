public class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int mod = 1000000007;

        int oddCount = 0;
        int evenCount = 1;

        int sum = 0;
        int ret = 0;
        for(int n : arr){
            sum += n;

            if(sum % 2 == 0){

                ret += oddCount;
                ret %= mod;

                evenCount++;
            }else{

                ret += evenCount;
                ret %= mod;

                oddCount++;
            }
        }

        return ret;

    }
}
