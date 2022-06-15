package p300plus.p395;

public class Solution {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> allCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            allCount.put(c, allCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> winCount = new HashMap<>();
        int qualified = 0;

        int left = 0;
        int right = 0;
        int ret = 0;
        char[] cs = s.toCharArray();

        while (right < s.length()) {
            char r = cs[right];
            if (allCount.get(r) < k) {
                if (qualified > 0) {

                    ret = Math.max(ret, longestSubstring(s.substring(left, right), k));
                }

                for(Map.Entry<Character,Integer> entry : winCount.entrySet()){
                    allCount.put(entry.getKey(),allCount.get(entry.getKey()) - entry.getValue());
                }

                left = right + 1;
                right = right + 1;
                winCount = new HashMap<>();
                qualified = 0;
            } else {
                winCount.put(r, winCount.getOrDefault(r, 0) + 1);
                if (winCount.get(r) == k) {
                    qualified++;
                }
                if (winCount.size() == qualified) {
                    ret = Math.max(ret, right - left + 1);
                }
                right++;
            }
        }
        return ret;
    }
}
