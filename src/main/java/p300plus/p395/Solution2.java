package p300plus.p395;

public class Solution2 {
    int ret = 0;
    public int longestSubstring(String s, int k) {
        
        longestSubstring(s,0,s.length()-1,k);
        return ret;
    }

    public void longestSubstring(String s,int start,int end,int k){
        if(end - start + 1 <= ret || end - start + 1 < k){
            return;
        }
        int qualified = 0;
        Map<Character, Integer> allCount = new HashMap<>();
        for (int i = start;i <= end;i++) {
            char c = s.charAt(i);
            allCount.put(c, allCount.getOrDefault(c, 0) + 1);
            if(allCount.get(c) == k){
                qualified++;
            }
        }
        if(allCount.size() == qualified){
            ret = Math.max(ret,end - start + 1);
            return;
        }

        int left = -1;
        for(int i = start;i <= end;i++){
            if(allCount.get(s.charAt(i)) < k){
                if(left != -1 && i - left >= k){
                    longestSubstring(s,left,i-1,k);
                }
                left = -1;
            }else{
                if(left == -1){
                    left = i;
                }
            }
        }
        if(left != -1){
            longestSubstring(s,left,end,k);
        }
    }
}
