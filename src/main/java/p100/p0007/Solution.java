package p100.p0007;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/26 20:25
 */
public class Solution {

    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        int ans = 0;
        while (x != 0){
            int i = x % 10;
            x /= 10;

            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && i > 7)){
                return 0;
            }

            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && i < -8)){
                return 0;
            }
            ans *= 10;
            ans += i;
        }
        return ans;
    }

    public static void main(String[] args){
        int x = 120;
        Solution solution = new Solution();
        System.out.println(solution.reverse(x));
    }

}
