package p300plus.p349;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ret = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums1){
            set1.add(n);
        }
        for(int n : nums2){
            if(set1.contains(n)){
                ret.add(n);
            }
        }
        int[] res = new int[ret.size()];
        int i = 0;
        for(int n : ret){
            res[i] = n;
            i++;
        }
        return res;
    }
}
