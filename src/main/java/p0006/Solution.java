package p0006;

import java.util.ArrayList;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/24 20:16
 */
public class Solution {

    public String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }

        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int curRow = 0;
        boolean isGoDown=false;

        for (int i = 0; i < s.length(); i++) {
            list.get(curRow).append(s.charAt(i));
            if(curRow == 0 || curRow+1==numRows){
                isGoDown = !isGoDown;
            }
            curRow += isGoDown?1:-1;
        }

        StringBuffer result = new StringBuffer();
        for (StringBuilder stringBuffer : list) {
            result.append(stringBuffer);
        }
        return result.toString();
    }

    public static void main(String[] args){
        String s = "LEETCODEISHIRING";
        int rownums = 4;
        Solution solution = new Solution();
        System.out.println(solution.convert(s,rownums));

    }

}
