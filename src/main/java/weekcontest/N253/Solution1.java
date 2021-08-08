package weekcontest.N253;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 */
public class Solution1 {


    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if(sb.length() > s.length()){
                return false;
            }else if(sb.length() == s.length()){
                return s.equals(sb.toString());
            }
        }
        return false;
    }

    public static void main(String[] args){
    }

}
