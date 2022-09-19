package p300plus.p698;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % k != 0){
            return false;
        }
        int target = sum/k;
        int[] bucket = new int[k];

        Arrays.sort(nums);

        return dfs(nums,k,bucket,nums.length-1,target);
    }

    boolean dfs(int[] nums, int k,int[] bucket,int idx,int target){
        if(idx == -1){
            return true;
        }
        for(int i = 0;i < k;i++){
            if(idx == nums.length-1 && i > 0){
                return false;
            }
            if(i > 0 && bucket[i] == bucket[i-1]){
                continue;
            }

            if(bucket[i] + nums[idx] > target){
                continue;
            }

            bucket[i] += nums[idx];

            if(dfs(nums,k,bucket,idx-1,target)){
                return true;
            }

            bucket[i] -= nums[idx];
        }
        return false;
    }
}
