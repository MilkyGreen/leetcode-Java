package p100.p0044;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/3/28 23:31
 */
public class Solution {

    public static void main(String[] args) {
//        System.out.println("Sluotion".indexOf('o',0));
//        System.out.println("Solution".indexOf('o',2));
//        System.out.println("So".substring(2));
        System.out.println(new Solution().isMatch("mississippi", "m??*ss*?i*pi"));
        System.out.println(new Solution().removeDulicateStars("*m??**ss*?i*pi**"));
    }

    Map<String, Boolean> dp = new HashMap<>();

    public boolean isMatch(String s, String p){
        return findMatch(s,removeDulicateStars(p));
    }

    public boolean findMatch(String s, String p) {
        String key = s + ":" + p;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (p.length() == 0) {
            dp.put(key, s.length() == 0);
            return dp.get(key);
        }
        if ("*".equals(p)) {
            dp.put(key, true);
            return dp.get(key);
        }

        if (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || '?' == p.charAt(0))) {
            dp.put(key, findMatch(s.substring(1), p.substring(1)));
        } else {
            if (!s.isEmpty()) {
                if ('*' == p.charAt(0)) {

                    boolean match1 = findMatch(s, p.substring(1));
                    boolean match2 = findMatch(s.substring(1), p);
                    dp.put(key, (match1 || match2));
                } else {
                    dp.put(key, false);
                }
            } else {
                if ('*' == p.charAt(0)) {
                    dp.put(key, findMatch(s, p.substring(1)));
                } else {
                    dp.put(key, false);
                }
            }
        }
        return dp.get(key);
    }

    public String removeDulicateStars(String str) {
        if(str.length() == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        String newStr = String.valueOf(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if ('*' == chars[i] && '*' == chars[i - 1]) {
                continue;
            }
            newStr += String.valueOf(chars[i]);
        }
        return newStr;
    }


}
