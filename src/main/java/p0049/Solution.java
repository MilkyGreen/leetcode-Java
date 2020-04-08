package p0049;

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

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.computeIfAbsent(new String(chars), k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams(strs);
    }

}
