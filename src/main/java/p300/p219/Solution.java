package p300.p219;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int len = nums.length;
        if(len == 1 || k == 0){
            return false;
        }
        int left = 0;
        int right = 0;
        Set<Integer> counter = new HashSet<>();
        while(right <= k && right < len){
            if(counter.contains(nums[right])){
                return true;
            }
            counter.add(nums[right++]);
        }


        while(right < len){
            counter.remove(nums[left]);
            left++;

            int newVal = nums[right];
            if(counter.contains(newVal)){
                return true;
            }
            counter.add(newVal);
            right++;
        }
        return false;
    }
}
