package p100.p0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by simon on 2020/2/16.
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> aus = new ArrayList<List<Integer>>();

        Arrays.sort(nums);


        for (int first = 0; first < nums.length - 3; first++) {
//            if(nums[first] > target) break;
            if(first > 0 && nums[first] == nums[first - 1]) continue;
            for (int second = first + 1; second < nums.length -2; second++) {
                if(second > first + 1 && nums[second] == nums[second - 1]) continue;
                int left = second+1;
                int right = nums.length - 1;
                while (left < right){

                    int sum = nums[first] + nums[second] + nums[left] + nums[right];
                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        if((nums[left] == nums[left + 1]) && left + 1 != right){
                            left++;
                        }else if((nums[right] == nums[right - 1]) && left + 1 != right){
                            right--;
                        }else {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[first]);
                            list.add(nums[second]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            aus.add(list);
                            left++;
                            right--;
                        }
                    }

                }
            }
        }
        return aus;
    }

    public static void main(String[] args){

        Solution solution = new Solution();
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {0, 0, 0, 0,0,0};
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        System.out.println(solution.fourSum(nums,-11));
    }

}
