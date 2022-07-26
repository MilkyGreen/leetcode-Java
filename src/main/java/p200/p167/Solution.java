package p200.p167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;

        for(int i = 0;i < len-1;i++){
            int first = i;
            int left = i + 1;
            int right = len - 1;
            while(left <= right){
                int mid = left + ((right - left) >> 1);
                int sum = numbers[first] + numbers[mid];
                if(sum == target){
                    return new int[]{first+1,mid+1};
                }else if(sum < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return new int[]{1,2};
        
    }
}
