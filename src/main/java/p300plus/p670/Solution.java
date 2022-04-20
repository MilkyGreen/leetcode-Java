package p300plus.p670;

public class Solution {
    public int maximumSwap(int num) {
        int n = num;
        List<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add(0,n % 10);
            n /= 10;
        }
        int[] nums = new int[list.size()];
        for(int j = 0;j < list.size();j++){
            nums[j] = list.get(j);
        }

        list.sort((i1,i2) -> i2 - i1);

        for(int j = 0;j < list.size();j++){
            int jth = list.get(j);
            if(nums[j] != jth){
                for(int k = list.size() - 1;k >= 0;k--){
                    if(nums[k] == jth){
                        int tmp = nums[k];
                        nums[k] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                break;
            }
        }
        int ret = 0;
        for(int j = 0;j< list.size();j++){
            ret = ret * 10 + nums[j];
        }
        return ret;
    }
}
