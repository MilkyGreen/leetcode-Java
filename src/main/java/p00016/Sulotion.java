package p00016;

import java.util.Arrays;

/**
 * Created by simon on 2020/2/12.
 */
public class Sulotion {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-1; i++) {

            int start = i + 1;
            int end = nums.length-1;

            while (start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(Math.abs(target - sum) < Math.abs(target - result)){
                    result = sum;
                }

                if(target < sum){
                    end--;
                }else if(target > sum){
                    start++;
                }else {
                    return sum;
                }
            }
        }
        return result;

    }

    public static void main(String[] args){
        Sulotion sulotion = new Sulotion();
        int[] nums = {0,2,1,-3};
        System.out.println(sulotion.threeSumClosest(nums,1));
    }
}
