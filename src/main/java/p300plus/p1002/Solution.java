package p300plus.p1002;

public class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ret = new ArrayList<>();
        Map<Character,Integer> preMap = new HashMap<>();
        for(int i = 0; i < words.length;i++){
            String s = words[i];
            if(i == 0){
                for(char c : s.toCharArray()){
                    preMap.put(c,preMap.getOrDefault(c,0)+1);
                }
            }else{
                Map<Character,Integer> currMap = new HashMap<>();
                for(char c : s.toCharArray()){
                    if(preMap.containsKey(c)){
                        currMap.put(c,currMap.getOrDefault(c,0)+1);
                    }
                }
                for(char c : currMap.keySet()){
                    currMap.put(c,Math.min(currMap.get(c),preMap.get(c)));
                }
                preMap = currMap;
            }
        }
        for(Map.Entry<Character,Integer> e : preMap.entrySet()){
            char c = e.getKey();
            Integer count = e.getValue();
            for(int i = 0;i < count;i++){
                ret.add(c + "");
            }
        }
        return ret;
    }
}
