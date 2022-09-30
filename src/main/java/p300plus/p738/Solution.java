package p300plus.p738;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        List<Integer> list = new ArrayList<>();
        int i = n;
        while(i != 0){
            list.add(i % 10);
            i /= 10;
        }
        int len = list.size();
        for(int j = 1;j < len;j++){
            if(list.get(j) > list.get(j - 1)){
                list.set(j,list.get(j)-1);
                for(int k = j-1;k >= 0;k--){
                    list.set(k,9);
                }
            }
        }
        int ret = 0;
        for(int j = len - 1;j >= 0;j--){
            ret = ret * 10 + list.get(j);
        }
        return ret;
    }
}
