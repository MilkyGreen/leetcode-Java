package p100.p0003;

import java.util.HashMap;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/22 20:43
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        return solution2(s);

    }

    public int solution1(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c) > 1){ // 不符合，left向前

                // 左边char计数减一
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);

                while (leftChar != c){// 直到移除c
                    left++;
                    leftChar = s.charAt(left);
                    map.put(leftChar,map.get(leftChar)-1);
                }

                left++;
            }else{ // 符合，right向前
                int i = right - left + 1;
                if(i > max){
                    max = i;
                }
            }
        }
        return max;
    }

    public int solution2(String s){
        HashMap<Character, Integer> map = new HashMap<>();//字符-位置 映射
        int n = s.length();
        int ans = 0;
        for (int j = 0,i = 0; j < n; j++) {
            char c = s.charAt(j);
            if(map.containsKey(c)){
                i = Math.max(map.get(c)+1,i);
            }
            map.put(c,j);
            ans = Math.max(ans,j - i +1);
        }
        return ans;
    }



    public static void main(String[] args){
        String s = "abcabcbb";
        String t = "bbbbb";
        String u = "pwwkew";
        String v = "tmmzuxt";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(u);
        System.out.println(i);
    }

}
