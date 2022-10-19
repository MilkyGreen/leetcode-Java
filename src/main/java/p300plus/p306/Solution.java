package p300plus.p306;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        
        char[] cs = num.toCharArray();
        if(cs.length < 3){
            return false;
        }
        long first = 0;
        long secend = 0;
        if(cs[0] == '0'){
            if(cs[1] == '0'){
                secend = 0;
                if(valid(first,secend,2,cs)){
                    return true;
                }
            }else{
                for(int j = 1;j < cs.length;j++){
                    secend = Long.valueOf(num.substring(1,j+1));
                    if(valid(first,secend,j+1,cs)){
                        return true;
                    }
                }
            }
            return false;
        }else{
            for(int i = 0;i < cs.length-1;i++){
                first = Long.valueOf(num.substring(0,i+1));
                if(cs[i+1] == '0'){
                    secend = 0;
                    if(valid(first,secend,i+2,cs)){
                        return true;
                    }
                }else{
                    for(int j = i+1;j < cs.length;j++){
                        secend = Long.valueOf(num.substring(i+1,j+1));
                        if(valid(first,secend,j+1,cs)){
                            return true;
                        }
                    }
                }
                
            }
            return false;
        }
    }

    boolean valid(long first,long secend,int idx,char[] cs){
        long sum = first + secend;
        while(idx < cs.length){
            long third = cs[idx] - '0';
            idx++;
            if(third != 0){
                while(third < sum && idx < cs.length){
                    third = third * 10 + (cs[idx] - '0'); 
                    idx++;
                }
            }
            if(third == sum){
                if(idx == cs.length){
                    return true;
                }
                sum = third + secend;
                secend = third;
            }else{
                return false;
            }
        }
        return false;
    }
}
