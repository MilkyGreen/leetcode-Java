package p100.p0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by simon on 2020/2/29.
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        if(s == null || words.length == 0){
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        int wordNum = words.length;
        int wordLen = words[0].length();

        Map<String, Integer> wordNumMap = new HashMap<>();
        for (String word : words) {
            wordNumMap.put(word,wordNumMap.getOrDefault(word,0)+1);
        }
        for (int i = 0; i < s.length() - wordLen*wordNum + 1; i++) {
            int count = 0;
            Map<String,Integer> tempMap = new HashMap<>();
            tempMap.putAll(wordNumMap);
            while (count<wordNum){
                String sub = s.substring(i + count * wordLen, i + (count + 1) * wordLen);
                if(tempMap.containsKey(sub)){
                    Integer subCount = tempMap.get(sub);
                    if(subCount == 1){
                        tempMap.remove(sub);
                    }else{
                        tempMap.put(sub,subCount-1);
                    }
                }else{
                    break;
                }
                count++;
            }
            if(tempMap.size() == 0){
                ans.add(i);
            }
        }

        return ans;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] words = {"foo","bar"};
        System.out.println(solution.findSubstring("barfoothefoobarman",words));

    }

}
