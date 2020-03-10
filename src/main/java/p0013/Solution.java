package p0013;

import java.util.HashMap;

/**
 * Created by simon on 2020/2/9.
 */
public class Solution {

    public int romanToInt(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(romans[i],nums[i]);
        }

        char[] chars = s.toCharArray();

        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            // 当前数字
            Integer currentNum = map.get(chars[i]+"");
            if(i > 0){
                // 上一个数字
                Integer frontNum = map.get(chars[i - 1]+"");
                if(frontNum < currentNum){
                    // 遇到了特殊数字
                    result -= frontNum;
                    Integer realNum = map.get(chars[i - 1] + "" + chars[i]);
                    result += realNum;
                }else{
                    result += currentNum;
                }
            }else{
                result += currentNum;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

}
