package p300plus.p1390;

public class Solution {
    public int sumFourDivisors(int[] nums) {
        int ret = 0;
        for(int num : nums){
            int last_d = 0;
            for(int i = 2;i * i <= num;i++){
                if(num % i == 0){
                    if(last_d == 0){
                        last_d = i;
                    }else{
                        last_d = 0;
                        break;
                    }
                }
            }
            if(last_d > 0 && last_d*last_d != num){
                ret += (1 + num + last_d + num/last_d);
            }
        }
        return ret;
    }
}
