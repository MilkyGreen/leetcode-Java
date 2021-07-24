package weekcontest.N057;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 */
public class Solution1 {

    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        int c = 0;
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            if(c == 0){
                c = value;
            }else {
                if (c != value){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().areOccurrencesEqual("aabbb"));
    }
}
