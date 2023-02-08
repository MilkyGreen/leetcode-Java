package p300plus.p791;

public class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> weights = new HashMap<>();
        int len = order.length();
        for(int i = 0;i < len;i++){
            weights.put(order.charAt(i),i+1);
        }
        char[] chars = s.toCharArray();
        Character[] cs = new Character[s.length()];
        for(int i = 0;i < s.length();i++){
            cs[i] = chars[i];
        }
        Arrays.sort(cs,(a,b) ->{
            return weights.getOrDefault(a, 0) - weights.getOrDefault(b, 0);
        });
        for(int i = 0;i < s.length();i++){
            chars[i] =  cs[i];
        }
        return new String(chars);
    }
}
