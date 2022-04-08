package p100.p011;

public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if(n <= 1){
            return 0;
        }
        int ret = Math.min(height[0],height[n-1]) * (n-1);
        int left = 0;
        int right = n-1;
        while(left < right){
            if(height[left] < height[right]){
                int oldLeft = left;
                while(left < right && height[left] <= height[oldLeft]){
                    left++;
                }
            }else{
                int oldRight = right;
                while(left < right && height[right] <= height[oldRight]){
                    right--;
                }
            }
            if(left < right){
                ret = Math.max(ret,Math.min(height[left],height[right]) * (right - left));
            }
        }
        return ret;
    }
}
