package p200.p168;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().convertToTitle(52);
    }


    public String convertToTitle(int columnNumber) {
        List<Integer> list = new ArrayList<>();
        while(columnNumber > 0){
            columnNumber--;
            list.add(columnNumber%26);
            columnNumber = columnNumber/26;
        }
        String res = "";
        for(int i = list.size()-1;i>=0;i--){
            res += (char)('A' + list.get(i));
        }

        return res;
    }
}
