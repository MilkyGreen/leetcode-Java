package p100.p0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2020/4/8 22:35
 */
public class Solution {

    Map<String,Map<Character,Integer>> strCharCount = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        // str -> anagrams
        Map<String,List<String>> groups = new HashMap<>();
        Map<Integer,List<String>> lenStrs = new HashMap<>();

        for(String str : strs){
            int len = str.length();
            boolean has = false;
            if(lenStrs.containsKey(len)){
                List<String> sameLens = lenStrs.get(len);
                for(String s : sameLens){
                    if(isAnagrams(s,str)){
                        has = true;
                        groups.get(s).add(str);
                    }
                }
                if(!has){
                    sameLens.add(str);
                }
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                lenStrs.put(len,list);
            }
            if(!has){
                List<String> strGroups = new ArrayList<>();
                strGroups.add(str);
                groups.put(str,strGroups);


            }
        }

        for(Map.Entry<String,List<String>> entry : groups.entrySet()){
            ret.add(entry.getValue());
        }

        return ret;
    }

    boolean isAnagrams(String a,String b){
        Map<Character,Integer> aMap = countChar(a);
        Map<Character,Integer> bMap = countChar(b);

        for(Map.Entry<Character,Integer> entry : aMap.entrySet()){ 
            if(!(bMap.containsKey(entry.getKey()) && bMap.get(entry.getKey()) == entry.getValue())){
                return false;
            }
        }
        return true;
    }

    Map<Character,Integer> countChar(String str){
        if(strCharCount.containsKey(str)){
            return strCharCount.get(str);
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        strCharCount.put(str,map);
        return map;
    }

}
