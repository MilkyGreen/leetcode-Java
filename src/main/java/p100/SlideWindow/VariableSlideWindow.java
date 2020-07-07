package p100.SlideWindow;

import java.util.HashMap;

/**
 * @author liyunmeng
 * @Description: 可变滑动窗口
 * @Date 2019/12/21 22:42
 */
public class VariableSlideWindow {

    public static void main(String [] args) {

//        String s = "ADOBECODEBANC";
        String s = "BANCADOBECODE";
        String t = "ABC";
        VariableSlideWindow s1 = new VariableSlideWindow();
        String ans = s1.minWindow(s,t);
        System.out.println(ans);

        s = "aa";
        t = "aa";
        ans = s1.minWindow(s,t);
        System.out.println(ans);
    }

    public String minWindow(String s,String t){
        int min = s.length();
        String ans = s;
        // 符合目标字符的数量
        int count = 0;
        // 目标字符和数量
        HashMap<Character, Integer> tMap = new HashMap<>();
        // 当前窗口符合的字符和数量
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if(tMap.containsKey(rightChar)){
                windowMap.put(rightChar,windowMap.getOrDefault(rightChar,0)+1);
                if(windowMap.get(rightChar) == tMap.get(rightChar)){
                    count++;
                }
            }

            // 不符合继续向前
            if(count < tMap.size()){
                continue;
            }

            // 符合条件，left增加。不符合时退出
            while (count >= tMap.size()){

                // 如果当前是最小长度，截取
                if(right - left + 1 <= min){
                    min = right - left + 1;
                    ans = s.substring(left,right+1);
                }

                char leftChar = s.charAt(left);
                if(windowMap.containsKey(leftChar)){
                    windowMap.put(leftChar,windowMap.getOrDefault(leftChar,0)-1);
                    if(windowMap.get(leftChar) < tMap.get(leftChar)){
                        count--;
                    }
                }
                left++;
            }
        }
        return ans;
    }

}
