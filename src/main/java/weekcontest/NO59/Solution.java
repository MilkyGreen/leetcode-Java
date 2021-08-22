package weekcontest.NO59;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().toBinS(5));
        System.out.println(Integer.toBinaryString(5));
    }


    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int max = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            max += Math.pow(2,i+1);
            set.add(nums[i]);
        }

        for(int i = 0;i<=max;i++){
            String s = Integer.toBinaryString(i);
            while(s.length() < n){
                s = "0" + s;
            }
            if(!set.contains(s)){
                return s;
            }
        }
        return "";
    }

    public String toBinS(int n){
        String str = "";
        while (n != 0){
            if(n % 2 == 0){
                str = "0"+str;
            }else {
                str = "1"+str;
            }
            n = n / 2;
        }
        return str;
    }

}
