package p300plus.p1456;

public class Solution {
    public int maxVowels(String s, int k) {

        int max = 0;
        char[] cs = s.toCharArray();
        int left = 0;
        int right = 0;
        int currV = 0;
        for(int i = 0;i < k;i++){
            if(isVowels(cs[right])){
                currV++;
                max = Math.max(max,currV);
            }
            right++;
        }

        while(right < cs.length){
            if(isVowels(cs[right])){
                currV++;
            }

            if(isVowels(cs[left])){
                currV--;
            }
            max = Math.max(max,currV);
            right++;
            left++;
        }
        return max;

    }

    private boolean isVowels(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';
    }
}
