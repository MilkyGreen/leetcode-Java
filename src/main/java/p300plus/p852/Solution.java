package p300plus.p852;

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == 0){
                left = 1;
            }else if(mid == len - 1){
                right = len - 2;
            }else{
                if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                    return mid;
                }else if(arr[mid-1] > arr[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                    
                }
            }
        }
        return 0;
    }
}
