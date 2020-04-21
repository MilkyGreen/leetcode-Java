package p0001;

import java.util.HashMap;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/18 20:54
 */
public class TowSum {

    public static void main(String[] args){
        int[] nums = {3,3};
        int target = 6;
        int[] ints = twoSum2(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt + " ");
        }
    }

    static int[] towSum(int[] nums,int target){
        int[] result = new int[]{0,0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1+i; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


    static int[] twoSum2(int[] nums,int target){
        int[] result = new int[]{0,0};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            Integer toSeek = target - key;
            if(map.containsKey(toSeek) && map.get(toSeek) != i){
                result[0] = i;
                result[1] = map.get(toSeek);
                return result;
            }
        }
        return result;
    }

}
