package p0071;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * <p>
 * Copyright: Copyright (c) 2020/6/3 22:37
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 思路：用stack来保存有效路径信息，遇到.不做操作，遇到..出栈一个元素，其他正常入栈，最后输出路径。
     * -> 击败6% Java解题，哈哈，代码略丑陋。。。
     * 看了别人解题发现，其实不用专门处理前面的特殊情况，直接按/分割即可，只会多一些''字符串而已，不入栈就行了
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

        Deque<String> deque = new ArrayDeque<>();
        while (path.contains("//")){
            path = path.replaceAll("//", "/");
        }
        while (path.contains("/./")){
            path = path.replaceAll("/\\./", "/");
        }

        if (path.startsWith("./")) {
            path = path.substring(2);
        } else if (path.endsWith("/.")) {
            path = path.substring(0, path.length() - 2);
        }

        String[] chars = path.split("/");
        for (int i = 0; i < chars.length; i++) {
            if ("..".equals(chars[i])) {
                if (deque.size() != 0) {
                    deque.removeLast();
                }
            } else {
                if(!"".equals(chars[i])){
                    deque.addLast(chars[i]);
                }
            }
        }

        if (deque.size() == 0) {
            return "/";
        } else {
            StringBuilder builder = new StringBuilder();
            for (String character : deque) {
                if(!character.equals("")){
                    builder.append("/").append(character);
                }
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a//b////c/d//././/.."));
    }

}
