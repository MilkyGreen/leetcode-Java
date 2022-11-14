package p300plus.p524;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String max = "";
        int maxLen = 0;
        Collections.sort(dictionary);
        outter : for(String target : dictionary){
            int i = 0;
            inner : for(char c : target.toCharArray()){
                while(i < s.length()){
                    if(s.charAt(i) == c){
                        i++;
                        continue inner;
                    }
                    i++;
                }
                continue outter;
            }
            if(target.length() > maxLen){
                maxLen = target.length();
                max = target;
            }
        }
        return max;
    }
}
