package p0033;

/**
 * @author liyunmeng
 * @Description: 搜索旋转排序数组
 * @Date 2020/3/5 23:22
 */
public class Solution {

    public int search(int[] nums, int target) {
        int ans = -1;
        if(nums.length == 0){
            return ans;
        }

        // 先找数组最小值的位置
        int left = 0;
        int right = nums.length - 1;
        int miniIndex = 0;
        while (left <= right){

            int mid = (right - left)/2 + left;
            int midNum = nums[mid];
            if(mid > 0 && midNum < nums[mid - 1]){
                miniIndex = mid;
                break;
            }
            if(midNum > nums[right]){
                left = mid + 1;
            }else if(midNum < nums[left]){
                right = mid -1;
            }else{
                miniIndex = left;
                break;
            }
        }

        left = 0;
        right = nums.length - 1;
        // 查找目标数字
        if(nums[right] >= target){
            left = miniIndex;
        }else{
            right = miniIndex - 1;
        }
        while (left <= right){
            int mid = (right - left)/2 + left;
            int midNum = nums[mid];
            if(midNum == target){
                ans = mid;
                break;
            }
            if(midNum > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }


    public static void main(String[] args){
//        int[] nums = {3,4,5,6,7,8,9,0,1,2};
        int[] nums = {3,1};
//        int[] nums = {11,12,3,4,5,6,7,8,9};
        int target = 0;
        Solution solution = new Solution();
        System.out.println(solution.search(nums,target));
    }
}
