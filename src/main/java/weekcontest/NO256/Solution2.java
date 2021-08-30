package weekcontest.NO256;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>
 */
public class Solution2 {


    public static void main(String[] args) {

    }


    public String kthLargestNumber(String[] nums, int k) {

        Arrays.sort(nums,(s1,s2)-> {
            int l1 = s1.length();
            int l2 = s2.length();
            if(l1 == l2){
                for (int i = 0; i < l1; i++) {
                    if(s1.charAt(i) > s2.charAt(1)){
                        return 1;
                    }else if(s1.charAt(i) < s2.charAt(1)){
                        return -1;
                    }
                }
                return 0;
            }else {
                return l1 > l2 ? 1 : -1;
            }
        });
        return nums[nums.length-k];
    }
}
