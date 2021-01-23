package p200.p131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * //给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * //
 * // 返回 s 所有可能的分割方案。
 * //
 * // 示例:
 * //
 * // 输入: "aab"
 * //输出:
 * //[
 * //  ["aa","b"],
 * //  ["a","a","b"]
 * //]
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int l = s.length();
        if(l == 0){
            return res;
        }
        boolean[][] dp = new boolean[l][l]; // dp[i][j] 表示s从i到j间的字符串是否是回字串
        for (int i = 0; i < l; i++) {
            // 回字串有可能是a或aa，所以分两种情况依次判断
            preDetermine(dp,s,i,i); // 判断中心是一个字符
            preDetermine(dp,s,i,i+1); // 中心是两个字符或0个字符
        }

        // 经过上面的预判断，每个字符是不是回字就已知了。下面每次截取一点字符判断是不是回字，是的话继续截取，不是就返回。
        Deque<String> path = new ArrayDeque<>();
        dfs(dp,res,path,s,0);

        return res;
    }

    private void dfs(boolean[][] dp,List<List<String>> res,Deque<String> path,String s,int start){

        if(start == s.length()){
            // 截取到头了，说明前面都是回文串，找到了一组答案
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(dp[start][i]){
                path.addLast(s.substring(start,i+1));
                dfs(dp,res,path,s,i+1);
                path.removeLast();
            }
        }
    }

    /**
     * 中心扩展，判断start到end是否是回字串，是的话继续向两边扩展一步判断
     * @param dp
     * @param s
     * @param start 开始位置
     * @param end 结束位置
     */
    private void preDetermine(boolean[][] dp,String s,int start,int end){
        if(start > end || start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end)){
            return;
        }
        dp[start][end] = true;
        preDetermine(dp,s,start-1,end+1);
    }


    public static void main(String[] args){
        List<List<String>> partition = new Solution().partition("aab");
        System.out.println(partition);
    }
}
