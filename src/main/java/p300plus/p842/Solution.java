package p300plus.p842;

public class Solution {
    List<Integer> ret = new ArrayList<>();
    int maxLen = (Integer.MAX_VALUE+"").length();
    public List<Integer> splitIntoFibonacci(String num) {
        int len = num.length();
        if(num.charAt(0) == '0'){
            for(int j = 1;j < len - 1;j++){
                if(j >= maxLen){
                    break;
                }
                if(findFobonacci(num,1,j)){
                    return ret;
                }
            }
        }else{
            for(int i = 1;i < len - 2;i++){
                if(i >= maxLen){
                    break;
                }
                if(num.charAt(i) == '0'){
                    if(findFobonacci(num,i,1)){
                        return ret;
                    }
                }else{
                    for(int j = 1;j < len - i;j++){
                        if(j >= maxLen){
                            break;
                        }
                        if(findFobonacci(num,i,j)){
                            return ret;
                        }
                    }
                }
            }
        }
        ret.clear();
        return ret;
    }

    private boolean findFobonacci(String num,int fLen,int sLen){
        int len = num.length();

        int fEndIdx = fLen - 1;
        int sEndIdx = fLen + sLen - 1;

        long first = Long.parseLong(num.substring(0,fEndIdx+1));
        long secend = Long.parseLong(num.substring(fEndIdx+1,sEndIdx+1));
        long third = first + secend;
        ret.add((int)first);
        ret.add((int)secend);
        ret.add((int)third);
        int tEndIdx = sEndIdx + (third+"").length();

        while(tEndIdx < len){
            String thridStr = num.substring(sEndIdx+1,tEndIdx+1);
            if(thridStr.length() > 1 && thridStr.startsWith("0")){
                ret.clear();
                return false;
            }
            if(third != Long.parseLong(thridStr)){
                ret.clear();
                return false;
            }
            if(tEndIdx == len - 1){
                return true;
            }

            long newSecend = third;
            long newThird = third + secend;
            third = newThird;
            secend = newSecend;
            if(third > Integer.MAX_VALUE){
                ret.clear();
                return false;
            }

            sEndIdx = tEndIdx;

            tEndIdx = tEndIdx + (third+"").length();
            ret.add((int)third);
        }
        ret.clear();
        return false;
    }
}
