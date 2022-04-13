package p100.p0034;

public class Solution3 {
    int[] nums;
    int left = -1;
    int right = -1;
    int target;
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                left = mid;
                right = mid;
                getLeft(start,mid - 1);
                getRight(mid + 1,end);
                break;
            }
        }
        return new int[]{left,right};
    }

    void getLeft(int start,int end){
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                // 关键点：找最左边的target，判断mid-1是否相等即可
                if(mid == 0 || nums[mid] != nums[mid - 1]){
                    left = mid;
                    return;
                }else{
                    end = mid - 1;
                }
            }
        }
    }

    void getRight(int start,int end){
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                if(mid == nums.length - 1 || nums[mid] != nums[mid + 1]){
                    right = mid;
                    return;
                }else{
                    start = mid + 1;
                }
            }
        }
    }
}
