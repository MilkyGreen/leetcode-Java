package p200.p139;

import java.util.ArrayList;
import java.util.List;

/**
 * //给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * //
 * // 说明：
 * //
 * //
 * // 拆分时可以重复使用字典中的单词。
 * // 你可以假设字典中没有重复的单词。
 * //
 * //dp[0][i]   dp[i+1][n-1]
 * // 示例 1：
 * //
 * // 输入: s = "leetcode", wordDict = ["leet", "code"]
 * //输出: true
 * //解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * //
 * //
 * // 示例 2：
 * //
 * // 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * //输出: true
 * //解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * //     注意你可以重复使用字典中的单词。
 * //
 * //
 * // 示例 3：
 * //
 * // 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * //输出: false
 * //
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 代表s从0到i位可以被处理
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 0到j为true j到i也为true  则0到i为true
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] =true;
                    break;
                }
            }
        }
        return dp[n];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];// dp[i] 代表0到i是否能被拼接
        dp[0] = true;
        for(int i = 1;i<=n;i++){
            for(int j = i-1;j>=0;j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(new Solution().wordBreak2(s,list));
    }

}
