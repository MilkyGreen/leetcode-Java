package p300plus.p941;

public class Solution {
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if(len < 3){
            return false;
        }
        boolean increase = true;
        int pre = arr[0];
        for(int i = 1; i < len;i++){
            int curr = arr[i];
            if(curr == pre){
                return false;
            }
            if(increase){
                if(i == 1 && curr < pre){
                    return false;
                }

                if(curr < pre){
                    increase = false;
                }

            }else{
                if(curr >= pre){
                    return false;
                }
            }

            pre = curr;
        }
        return !increase;
    }
}
