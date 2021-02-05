package p200.p140;

import java.util.*;

/**
 * //给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
 * //句子。
 * //
 * // 说明：
 * //
 * //
 * // 分隔时可以重复使用字典中的单词。
 * // 你可以假设字典中没有重复的单词。
 * //
 * //
 * // 示例 1：
 * //
 * // 输入:
 * //s = "catsanddog"
 * //wordDict = ["cat", "cats", "and", "sand", "dog"]
 * //输出:
 * //[
 * //  "cats and dog",
 * //  "cat sand dog"
 * //]
 * //
 * //
 * // 示例 2：
 * //
 * // 输入:
 * //s = "pineapplepenapple"
 * //wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * //输出:
 * //[
 * //  "pine apple pen apple",
 * //  "pineapple pen apple",
 * //  "pine applepen apple"
 * //]
 * //解释: 注意你可以重复使用字典中的单词。
 * //
 * //
 * // 示例 3：
 * //
 * // 输入:
 * //s = "catsandog"
 * //wordDict = ["cats", "dog", "sand", "and", "cat"]
 * //输出:
 * //[]
 */
public class Solution {

    /**
     * 思路：回溯，每次选一截，依次匹配剩下的。 预计会超时。。。  果然超时了
     * 减枝情况：剩下的单词小于字典最小值；
     * @param s
     * @param wordDict
     * @return
     */

    int minl = 0;
    List<String> wordDict;
    List<String> res = new ArrayList<>();
    String s;
    public List<String> wordBreak(String s, List<String> wordDict) {

        // 先判断是否可以拆分成功,dp[i] 代表s从0到i-1能否被成功分割
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                // j在0和i中间，则0到j-1，j到i 决定了0到i是否呢拆分
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if(!dp[s.length()]){
            return res;
        }

        this.s = s;
        this.wordDict = wordDict;
        wordDict.forEach(word ->{
            minl = Math.min(word.length(),minl);
        });
        Deque<String> deque = new ArrayDeque<>();
        dfs(deque,0);
        return res;
    }

    private void dfs(Deque<String> path,int start){
        if(start == s.length()){
            StringBuffer sb = new StringBuffer();
            path.forEach(p -> sb.append(" ").append(p));
            res.add(sb.substring(1));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(i - start + 1 >= minl && s.length() - i + 1 >= minl){
                String sub = s.substring(start, i + 1);
                if(wordDict.contains(sub)){
                    path.addLast(sub);
                    dfs(path,i+1);
                    path.removeLast();
                }
            }
        }
    }


    public static void main(String[] args){
        List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String s = "catsandog";
        List<String> strings = new Solution().wordBreak(s, list);
        System.out.println(strings);
    }

}
