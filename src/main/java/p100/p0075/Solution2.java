package p100.p0075;

public class Solution2 {
    // 三指针，left指向下一个0的位置，right指向下一个2的位置，idx遍历数组
    // 遇到0，idx与left交换，遇到2，idx与right交换，1被剩到中间
    public void sortColors(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int idx = 0;
        while(idx < len && left < right && idx <= right){
            int num = nums[idx];
            if(num == 0){
                swap(idx,left,nums);
                left++;
                idx++; // 左边换回来的只能是1，因此不用再判断，idx++
            }else if(num == 2){
                swap(idx,right,nums);
                right--;
                // 从右边换来回的不知道是什么，需要继续判断，idx没有++
            }else{
                idx++;
            }
        }
    }

    void swap(int a ,int b,int[] nums){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
