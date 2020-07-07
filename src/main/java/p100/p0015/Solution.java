package p100.p0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by simon on 2020/2/11.
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left){
                if(nums[i] > 0){
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    if((nums[left] == nums[left + 1]) && left + 1 != right){
                        left++;
                    }else if((nums[right] == nums[right - 1]) && right - 1 != left){
                        right--;
                    }else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                    }
                }else if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {0,0,0,0};
        System.out.println(solution.threeSum(nums));
    }

}
