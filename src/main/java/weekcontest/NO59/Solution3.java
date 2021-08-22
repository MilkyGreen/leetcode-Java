package weekcontest.NO59;

/**
 */
public class Solution3 {


    public static void main(String[] args) {
        System.out.println(new Solution3().minTimeToType("zjpc"));
    }


    public int minTimeToType(String word) {
        int ans = 0;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char curr = i == 0 ? 'a' : word.charAt(i-1);
            int dist = Math.abs(curr - word.charAt(i));
            if(dist > 13){
                dist = 26 - dist;
            }
            ans += dist + 1;
        }
        return ans;
    }
}
