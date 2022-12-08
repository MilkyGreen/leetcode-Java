package p300plus.p386;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 1;i < 10;i++){
            dfs(ret,n,i);
        }
        
        return ret;
    }

    void dfs(List<Integer> ret,int n,int curr){
        if(curr > n){
            return;
        }
        if(curr != 0){
            ret.add(curr);
        }
        
        for(int i = 0;i < 10;i++){
            dfs(ret,n,curr*10 + i);
        }
    }
}
