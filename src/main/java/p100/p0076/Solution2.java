package p100.p0076;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class Solution2 {

    public static void main(String[] args) {
        String s = new Solution2().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        Map<Character, Integer> charCount = new HashMap<>();
        Map<Character, Integer> winCount = new HashMap<>();
        for (int i = 0; i < tl; i++) {
            Character c = t.charAt(i);
            charCount.put(c,charCount.getOrDefault(c,0)+1);
            winCount.put(c,0);
        }

        int left = 0;
        int right = 0;
        int minLen = sl+1;
        int minLeft = -1;
        int minRight = -1;
        while(right < sl){
            char c = s.charAt(right);
            if(winCount.containsKey(c)){
                winCount.put(c,winCount.getOrDefault(c,0)+1);
                if(winCount.get(c) >= charCount.get(c)){
                    // 触发判断
                    if(coverAll(charCount,winCount)){
                        if(right - left + 1 < minLen){
                            minLen = right - left + 1;
                            minLeft = left;
                            minRight = right;
                        }
                        while(left+tl <= right){
                            char l = s.charAt(left);
                            left++;
                            if(winCount.containsKey(l)){
                                winCount.put(l,winCount.get(l)-1);

                                if(winCount.get(l) >= charCount.get(l)){
                                    if(right - left + 1 < minLen){
                                        minLen = right - left + 1;
                                        minLeft = left;
                                        minRight = right;
                                    }
                                }else{
                                    break;
                                }
                            }else{
                                if(right - left + 1 < minLen){
                                    minLen = right - left + 1;
                                    minLeft = left;
                                    minRight = right;
                                }
                            }

                        }
                    }
                }
            }
            right++;
        }
        if(minLen == sl + 1){
            return "";
        }else{
            return s.substring(minLeft,minRight+1);
        }
    }

    public boolean coverAll(Map<Character, Integer> charCount,Map<Character, Integer> winCount){
        for(Map.Entry<Character,Integer> entry : charCount.entrySet()){
            if(winCount.get(entry.getKey()) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

}
