package p100.p0072;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * <p>
 * Copyright: Copyright (c) 2020/6/4 22:47
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 思路：word2是目标，在word1中依次寻找Word2中的字母，如果找不到，则直接将word1替换为word2。
     * 如果word1包含word2中的字母，则按顺序作为锚点，参照word2对word1进行改造.
     * -> 一顿分析猛如虎，结果第一个case都没过。。。太难了，老老实实看答案吧。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        // word1中与word2相同的字母在word1中的位置
        int[] existIndex = new int[word2.length()];
        // word1中与word2相同的字母在word2中的位置
        int[] word2Index = new int[word2.length()];
        // 相同字母数量
        int n = 0;
        char[] chars = word2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 从上个找到的字母位置之后，找word1中是否包含word2中的字母
            int i1 = word1.indexOf(String.valueOf(chars[i]), existIndex[n]);
            if (i1 > -1) {
                // 记录word1中重复的数字位置
                existIndex[n] = i1;

                // 记录word2中重复的数字位置
                word2Index[n] = i;
                n++;
            }
        }
        if (n == 0 || n == 1) {
            // 没有或只有一个重合数字，返回word2长度-n
            return word2.length() - n;
        } else {
            // 两个及一样字母重合的情况
            // 第一步，调整existIndex中的位置距离，和word2Index中的距离一样
            // 第一步要操作的步骤
            int m = 0;
            for (int i = 0; i < existIndex.length - 1; i++) {
                // word1中两个相同字母的距离
                int wordsDist1 = Math.abs(existIndex[i] - existIndex[i + 1]);

                // word1中两个相同字母的距离
                int wordsDist2 = Math.abs(word2Index[i] - word2Index[i + 1]);

                // 如果word1相同单词距离大，就需要删多余单词
                if (wordsDist1 > wordsDist2) {
                    m += Math.abs(wordsDist1 - wordsDist2);
                } else if (wordsDist2 > wordsDist1) {
                    // 如果word1相同单词距离小，就需要插入少的单词。这时肯定是插入word2中的其他单词，相同单词数量就要增加
                    m += Math.abs(wordsDist1 - wordsDist2);
                    n += Math.abs(wordsDist1 - wordsDist2);
                }
            }
            // 处理完距离之后，这时如果word2长度还比相同单词数多，则word1需要替换或者（在头、尾）新增操作
            m += word2.length() - n;
            return m;
        }
    }

    public static void main(String[] args){
        System.out.println(new Solution().minDistance("horse","ros"));
    }

}
