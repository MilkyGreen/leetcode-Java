package p100.p0081;

/**
 * Created by simon on 2020/8/3.
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

 */
public class Solution {

    /**
     * 思路：二分法，分开之后判断那边是有序的，再根据目标值与mid对比，继续对另一半的搜索。
     * 另一半有可能是有序，也有可能是翻转之后的，继续按照上面的逻辑处理就行了，直到找到或者结束。
     *
     * 速度击败100% Java提交。二分法多写写就行了，没啥特别的技巧。
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left+(right - left)/2;
            if(nums[left] == target || nums[right] == target|| nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid]){
                // 这里是为了排除干扰，如果相等判断不出是否有序，直接删掉即可，直到左边和mid不相等。
                left++;
            }else if(nums[left] < nums[mid]){
                // 左边有序
                if(target > nums[left] && target < nums[mid]){
                    // 核心是这里，必须先找到有序的一半，判断target是否在区间内。翻转的一半就无法这样快捷的判断，
                    // 所以放到else里面
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }else {
                // 右边有序
                if(target > nums[mid] && target < nums[right]){
                    left = mid + 1;
                }else {
                    right = mid -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){

    }

}
