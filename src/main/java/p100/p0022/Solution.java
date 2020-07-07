package p100.p0022;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 2020/2/19.
 */
public class Solution {

    public List<String> generateParenthesis(int n) {

        ArrayList<String> ans = new ArrayList<>();
        backTrace(ans,"",0,0,n);
        return ans;
    }


    private void backTrace(List<String> ans,String curr,int left,int right,int max){
        if(curr.length() == max*2){
            ans.add(curr);
        }
        if(left < max){
            backTrace(ans,curr+"(",left+1,right,max);
        }
        if(right < left){
            backTrace(ans,curr+")",left,right+1,max);
        }
    }

}
