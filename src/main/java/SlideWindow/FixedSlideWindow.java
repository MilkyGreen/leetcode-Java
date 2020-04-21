package SlideWindow;

/**
 * @author liyunmeng
 * @Description: 固定滑动窗口
 * @Date 2019/12/21 22:11
 */
public class FixedSlideWindow {

    public static void main(String [] args) {

        String s = "abcdeaaadfewfsaaadassaaaaaddddaass";

        int k = 5;

        char x = 'a';

        /*String s = "ADOBECODEBANC";
        String t = "ABC";
        FixedSlideWindow s1 = new FixedSlideWindow();
        String ans = s1.minWindow(s,t);
        System.out.println(ans);

        s = "aa";
        t = "aa";
        ans = s1.minWindow(s,t);*/
        FixedSlideWindow fixedSlideWindow = new FixedSlideWindow();
        System.out.println(fixedSlideWindow.maxCharNumber(s,k,x));
    }

    public int maxCharNumber(String s,int k,char x){
        int ans = 0;
        int currentNum = 0;
        for (int right = 0; right < s.length(); right++) {
            if(s.charAt(right) == x){
                currentNum++;
            }
            int left = right - k + 1;

            if(left > 0){
                if(s.charAt(left - 1) == x){
                    currentNum--;
                }
            }
            if(ans < currentNum){
                ans = currentNum;
            }
        }
        return ans;
    }
}
