package p300plus.p1673;

public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ret = new int[k];
        List<Integer> stack = new ArrayList<>();
        int n = nums.length;
        int canRemoveCount = n - k;
        for(int num : nums){
            while(stack.size() > 0 && canRemoveCount > 0 && stack.get(stack.size()-1) > num){
                stack.remove(stack.size()-1);
                canRemoveCount--;
            }
            stack.add(num);
        }
        for(int i = 0;i < k;i++){
            ret[i] = stack.get(i);
        }

        return ret;
    }
}
