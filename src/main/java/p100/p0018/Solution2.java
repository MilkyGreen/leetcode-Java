package p100.p0018;

public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 4){
            return ret;
        }

        for(int i = 0;i < n-3;i++){
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                return ret;
            }
            if((long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target){
                continue;
            }

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1;j < n - 2;j++){

                if((long)nums[i] + nums[j] + nums[j+1] + nums[j+2] > target){
                    break;
                }
                if((long)nums[i] + nums[j] + nums[n-1] + nums[n-2] < target){
                    continue;
                }

                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int left = j+1;
                int right = n-1;

                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        ret.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        while(left < n && nums[left-1] == nums[left]){
                            left++;
                        }
                        right--;
                        while(right >= 0 && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if(sum > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return ret;
    }
}
