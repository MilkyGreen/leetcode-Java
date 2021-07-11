package weekcontest.NO56;

/**
 * <p>
 */
public class Solution {

    public int countTriples(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = i*i + j*j;
                double sqrt = Math.sqrt(sum);
                if(sqrt <= n && nums[(int)sqrt - 1] == sqrt){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countTriples(10));
    }
}
