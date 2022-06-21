package p300plus.p421;

public class Solution {
    int HIGH_BIT = 30;
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for(int i = HIGH_BIT;i >= 0;i--){
            Set<Integer> seen = new HashSet<>();

            for(int num : nums){
                seen.add(num >> i);
            }

            int nextX = x * 2 + 1;
            boolean found = false;

            for(int num : nums){
                if(seen.contains((num >> i) ^ nextX)){
                    found = true;
                    break;
                }
            }

            if(found){
                x = nextX;
            }else{
                x = nextX - 1;
            }
        }
        return x;
    }
}
