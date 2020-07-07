package p100.p0034;

/**
 * @author liyunmeng
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * @Date 2020/3/11 22:47
 */
public class Solution {

    private int[] nums;
    private int target;
    private int[] ans = {-1,-1};
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        if(nums.length == 0){
            return ans;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                getLeft(left,mid);
                getRight(mid,right);
                break;
            }
        }
        return ans;
    }

    private void getLeft(int left,int right){
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    ans[0] = mid;
                    break;
                }else{
                    right = mid - 1;
                }
            }
        }
    }

    private void getRight(int left,int right){
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                if(mid == this.nums.length-1 || nums[mid] < nums[mid+1]){
                    ans[1] = mid;
                    break;
                }else{
                    left = mid + 1;
                }
            }
        }
    }

    public static void main(String[] args){
//        int[] nums ={5,7,7,8,8,10};
        int[] nums ={2,2};
        Solution solution = new Solution();
        int[] ints = solution.searchRange(nums, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}
