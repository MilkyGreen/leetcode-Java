package p100.p0076;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * Copyright: Copyright (c) 2020/7/7 20:18
 * <p>
 *
 * <p>
 *
 * @version 1.0.0
 */
public class Solution {
    /**
     * 思路：滑动窗口应该可以解决。从s左边开始每次向右移动一个字符，如果t包含当前字符，leftIndex 停止，
     * rightIndex 继续向前，直到T中的字符全部出现过，rightIndex 停止，leftIndex向前，每当遇到一个T中字符，
     * 判断当前是否符合要求，不符合的话 rightIndex继续向前。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        // 字符-窗口内出现次数
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> clt = new HashMap<>();
        for (char c : t.toCharArray()) {
            clt.put(c+"",clt.getOrDefault(c+"",0)+1);
        }

        int leftIndex = 0;
        int rightIndex = 0;

        int ansLeft = 0;
        int ansRight = s.length();

        boolean hasAns = false;

        while (leftIndex <= s.length()-t.length() && rightIndex <= s.length()){

            boolean contains = true;
            Set<Map.Entry<String, Integer>> entries = clt.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if(map.getOrDefault(entry.getKey(),0) < entry.getValue()){
                    contains = false;
                    break;
                }
            }

            if(contains){
                hasAns = true;
                if(rightIndex - leftIndex < ansRight - ansLeft){
                    ansRight = rightIndex;
                    ansLeft = leftIndex;
                }

                char c = s.charAt(leftIndex);
                if(t.contains(c+"")){
                    Integer charCount = map.get(c + "");
                    if(charCount <= 1){
                        map.remove(c + "");
                    }else {
                        map.put(c+"",charCount - 1);
                    }
                }
                leftIndex++;
            }else {
                if(rightIndex == s.length()){
                    break;
                }
                char c = s.charAt(rightIndex);
                if(t.contains(c+"")){
                    map.put(c+"",map.getOrDefault(c+"",0)+1);
                }
                rightIndex++;

            }
        }

        if(!hasAns){
            return s.equals(t) ? s:"";
        }else {
            return s.substring(ansLeft,ansRight);
        }

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC","ABC"));
    }

}
