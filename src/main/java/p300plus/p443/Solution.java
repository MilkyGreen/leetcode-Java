package p300plus.p443;

public class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        int dupLen = 0;
        for(int i=0;i<n;i++){
            if(i > 0){
                if(chars[i] == chars[i-1]){
                    dupLen++;
                }else{
                    if(dupLen > 1){
                        for(char c : (dupLen+"").toCharArray()){
                            chars[idx] = c;
                            idx++;
                        }
                    }
                    
                    chars[idx] = chars[i];
                    idx++;
                    dupLen = 1;
                }
            }else{
                chars[idx] = chars[i];
                idx++;
                dupLen = 1;
            }
        }
        if(dupLen > 1){
            for(char c : (dupLen+"").toCharArray()){
                chars[idx] = c;
                idx++;
            }
        }
        return idx;
    }
}
