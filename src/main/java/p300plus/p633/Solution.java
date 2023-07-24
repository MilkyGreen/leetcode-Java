package p300plus.p633;

public class Solution {
    public boolean judgeSquareSum(int c) {

        // Set<Integer> set = new HashSet<>();
        // Set<Integer> cant = new HashSet<>();

        int half = c/2 + 1;
        for(int i = 0;i*i < half;i++){
            int as = i*i;
            // set.add(as);
            int bs = c - as;
            // if(set.contains(bs)){
            //     return true;
            // }
            // if(cant.contains(bs)){
            //     continue;
            // }
            int b = (int)Math.sqrt(bs);
            if(b * b == bs){
                return true;
            }else{
                // cant.add(bs);
            }
        }

        return false;
    }
}
