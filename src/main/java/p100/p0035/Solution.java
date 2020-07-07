package p100.p0035;



/**
 * @author liyunmeng
 * @Description: 搜索插入位置
 * @Date 2020/3/14 23:30
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int ans = 0;
        if(nums.length == 0){
            return ans;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        Solution sulotion = new Solution();
        System.out.println(sulotion.searchInsert(nums,0));
    }
}
