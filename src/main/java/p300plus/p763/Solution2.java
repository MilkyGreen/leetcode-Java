package p300plus.p763;

public class Solution2 {
    public List<Integer> partitionLabels(String s) {

        List<Integer> ret = new ArrayList<>();
        int[] last = new int[26];
        char[] chars = s.toCharArray();
        for(int i = 0;i < chars.length;i++){
            last[chars[i] - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0;i < chars.length;i++){
            end = Math.max(end,last[chars[i] - 'a']);
            if(i == end){
                ret.add(end - start + 1);
                start = end + 1;
            }
        }

        return ret;
    }
}
