package p200.p151;

//给定一个字符串，逐个翻转字符串中的每个单词。
//
// 说明：
//
//
// 无空格字符构成一个 单词 。
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//
//
// 示例 1：
//
// 输入："the sky is blue"
//输出："blue is sky the"
//
//
// 示例 2：
//
// 输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//
//
// 示例 3：
//
// 输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
// 示例 4：
//
// 输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
//
//
// 示例 5：
//
// 输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 包含英文大小写字母、数字和空格 ' '
// s 中 至少存在一个 单词
//
//
//
//
//
//
//
// 进阶：
//
//
// 请尝试使用 O(1) 额外空间复杂度的原地解法。


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//
public class Solution {

    /**
     * 思路：常数空间，只能原地翻转，辅一些固定数量的变量。
     * 1、先把多余空格去掉
     * 2、找到第一个单词后移动到最后。直到每个单词都遍历一遍  不行。。。
     *
     * 2、从两头开始找单词，然后交换一下位置就行了。好像也不太行。。。
     *
     *
     * 官方解题竟然用的队列，也没有O(1)的方法，我擦！
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ");
        s = s.trim();
        String[] strings = s.split(" ");
        // 双端队列，顺序放进去，然后倒着取出来
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(strings));
        StringBuilder sb = new StringBuilder();
        while (deque.size() != 0){
            sb.append(" ").append(deque.removeLast());
        }
        return sb.substring(1);
    }

}
