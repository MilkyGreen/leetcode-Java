package p300.p263;

public class Solution {
    int[] factors = new int[]{2,3,5};
    Set<Integer> beauty = new HashSet<Integer>();
    public boolean isUgly(int n) {
        if(n < 0){
            return false;
        }
        if(beauty.contains(n)){
            return false;
        }
        if(n == 0){
            return false;
        }
        if(n == 1 || n == 2 || n == 3 || n == 5){
            return true;
        }
        for(int f : factors){
            if(n % f == 0){
                if(isUgly(n/f)){
                    return true;
                }else{
                    beauty.add(n/f);
                }
            }
        }
        return false;
    }
}
