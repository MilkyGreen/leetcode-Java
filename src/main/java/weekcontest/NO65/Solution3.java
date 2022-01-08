package weekcontest.NO65;

import java.util.HashMap;

/**
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String[] ws = new String[]{"ab","ty","yt","lc","cl","ab"};
        System.out.println(solution.longestPalindrome(ws));
    }


    public int longestPalindrome(String[] words) {
        int ret = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        boolean dupUsed = false;
        for (String word : words) {
            if(map.get(word) > 0){
                String reverse = new StringBuilder(word).reverse().toString();
                if(map.containsKey(reverse) && map.get(reverse) > 0 && word.charAt(0) != word.charAt(1)){
                    ret+=4;
                    map.put(word,map.get(word)-1);
                    map.put(reverse,map.get(reverse)-1);
                }else if(word.charAt(0) == word.charAt(1) && map.containsKey(reverse) && map.get(reverse) > 1){
                    ret+=4;
                    map.put(word,map.get(word)-1);
                    map.put(reverse,map.get(reverse)-1);
                }else{
                    if(!dupUsed){
                        if(word.charAt(0) == word.charAt(1)){
                            map.put(word,map.get(word)-1);
                            ret+=2;
                            dupUsed = true;
                        }
                    }
                }
            }
        }
        return ret;
    }


}
