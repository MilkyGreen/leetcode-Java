package p300plus.p331;

public class Solution {
    int idx = 0;
    String[] cs;
    public boolean isValidSerialization(String preorder) {
        this.cs = preorder.split(",");
        if(isValid()){
            return idx == cs.length;
        }else{
            return false;
        }
    }

    public boolean isValid(){
        if(idx >= cs.length){
            return false;
        }
        if(cs[idx].equals("#")){
            idx++;
            return true;
        }
        idx++;
        return isValid() && isValid();
    }
}
