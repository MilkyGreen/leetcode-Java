package p300plus.p763;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int sliceWordCount = 0;
        Set<Character> words = new HashSet<>();
        int start = 0;
        while(i < chars.length){
            if(words.contains(chars[i])){
                sliceWordCount--;
            }else{
                words.add(chars[i]);
                sliceWordCount += (map.get(chars[i]) - 1);
            }
            
            if(sliceWordCount == 0){
                ret.add(i - start + 1);
                start = i + 1;
            }
            i++;
        }
        return ret;
    }
}
