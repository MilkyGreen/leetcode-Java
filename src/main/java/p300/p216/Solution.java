package p300.p216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> path = new LinkedList<>();

        dfs(path,1,n,k,0);

        return res;
    }

    private void dfs(LinkedList<Integer> path,int num,int n,int k,int sum){
        if(sum > n){
            return;
        }

        if(k == path.size() ){
            if(sum == n){
                res.add(new ArrayList(path));
            }
            return;
        }

        for(int i = num;i <= 9;i++){
            path.addLast(i);

            dfs(path,i+1,n,k,sum + i);

            path.removeLast();
        }
    }
}
