package p300plus.p611;

public class Solution {
    // 三角形三边规律：两边之和大于第三边，两边和差小于第三边
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        int len = nums.length;
        for(int i = 0;i < len;i++){
            int first = nums[i];
            for(int j = i+1;j < len;j++){
                int second = nums[j];
                int left = j + 1;
                int k = j;
                int right = len - 1;
                
                // 先排序，依次组合前两个边，第三边只要符合 first + second > third 即可，在 j + 1 到 len - 1 区间内二分查找最大值k。
                while(left <= right){
                    int mid = left + ((right - left) >> 1);
                    if(first + second > nums[mid]){
                        k = mid;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }

                ret += (k - j);
            }
        }
        return ret;
    }
}
