
/**
 */
public class SimplestSort {

    public void sort(int[] nums){
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums.length;j++){
                if(nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,1,4,3,9,37,9,6,34};
        new SimplestSort().sort(nums);
    }

}
