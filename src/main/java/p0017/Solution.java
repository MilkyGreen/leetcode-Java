package p0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by simon on 2020/2/13.
 */
public class Solution {


    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ans;
        }
        getCombination("",digits);
        return ans;
    }
    List<String> ans = new ArrayList<String>();
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    private void getCombination(String combination,String leftDigits){
        if(leftDigits.length() == 0){
            ans.add(combination);
        }else{
            String s = leftDigits.substring(0, 1);
            String letters = phone.get(s);
            for (char c : letters.toCharArray()) {
                getCombination(combination+c,leftDigits.substring(1));
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

}
