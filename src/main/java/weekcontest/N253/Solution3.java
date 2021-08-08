package weekcontest.N253;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>
 */
public class Solution3 {


    public int minSwaps(String s) {
        if ("".equals(s)) {
            return 0;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('[' == c) {
                stack.push(c);
            } else {
                if (stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if (stack.size() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.removeLast());
        }
        String news = sb.toString();

        int l = news.length();
        if (l == 2) {
            return 1;
        }
        int step = 1;
        int index = 0;
        for (int i = 0; i < news.length(); i++) {
            if (news.charAt(i) == ']') {
                index = i;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < news.length(); i++) {
            char[] cs = news.toCharArray();
            if (cs[i] == '[') {
                cs[index] = '[';
                cs[i] = ']';
                min = Math.min(min, minSwaps(new String(cs)));
            }
        }
        return step + min;
    }

    public static void main(String[] args) {

        System.out.println(new Solution3().minSwaps("][][[][]][[][]]]]][][[[][[[]][]][[][[[][[]]][[[]]][[[[][][[]][]]]][]]][][]]][[][][[][]][[[[[[]]]][]]]][[]]][[][][[][[]]][[][]]][]]][[[]]][[][][[][[[[]][]]][[[[]][[]]]][[][[[[][][]][]][[]]]]][[[[[[[][][[[][]][]]][][][]]][][][]][[[][]]][]][[][]]]][]]][[]][[[]]]]]]]][]]][[[]]]][]][[[[][][[[[][[[][[[[[[[[][[][][][[]][[][[[]]][[]][][]][][]][[]]][[][]][]]][[][][]][[[][[][[[]][][][][[[[[[[][][[[]]][]][[[[[[[[][[[]]][[][[][][[][]]][]][[]]][]][[[][[]][][]][[[[]][[]]][][][]]]]][[[[[]][[[]]][][]][]]]]]][[]]][[[[[]][][]][[]]]]][[][]]]"));
    }

}
