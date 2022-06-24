package p300.p242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Long> sMap = new HashMap<>();
        Map<Character,Long> tMap = new HashMap<>();
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();
        if(scs.length != tcs.length){
            return false;
        }
        for(int i = 0;i< s.length();i++){
            sMap.put(scs[i],sMap.getOrDefault(scs[i],0L)+1L);
        }
        for(int i = 0;i< t.length();i++){
            tMap.put(tcs[i],tMap.getOrDefault(tcs[i],0L)+1L);
        }
        for(Map.Entry<Character,Long> e : sMap.entrySet()){
            if(!tMap.containsKey(e.getKey()) || (long)tMap.get(e.getKey()) != (long)e.getValue()){
                return false;
            }
        }
        return true;

    }
}
