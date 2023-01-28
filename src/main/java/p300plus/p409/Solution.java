package p300plus.p409;

public class Solution {
    public int longestPalindrome(String s) {
        int curr = 0;
        int ret = 0;
        Map<Character,Integer> counter = new HashMap<>();
        for(char c : s.toCharArray()){
            if(counter.containsKey(c) && counter.get(c) > 0){
                int count = counter.get(c);
                counter.put(c,count - 1);
                curr--;
                ret++;
            }else{
                counter.put(c,1);
                curr++;
            }
        }
        return curr == 0 ? ret*2 : ret*2 + 1;
    }
}
