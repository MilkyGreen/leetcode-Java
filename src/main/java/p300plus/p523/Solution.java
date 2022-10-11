package p300plus.p523;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] % k;
            if (n == 0 && i > 0) {
                return true;
            }
            Integer index = map.get(n);
            if (index == null) {
                map.put(n, i);
            } else if (i - index >= 2) { // 保证子数组长度大于2
                return true;
            }
        }
        return false;
    }
}
