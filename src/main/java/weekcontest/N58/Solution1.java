package weekcontest.N58;

/**
 * <p>
 */
public class Solution1 {


    public String makeFancyString(String s) {
        if("".equals(s)){
            return "";
        }
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder(chars[0]+"");
        char curr = chars[0];
        int currNum = 1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == curr){
                currNum++;
            }else{
                currNum=1;
            }
            if(currNum == 3){
                currNum--;
            }else {
                ans.append(chars[i]);
            }
            curr = chars[i];
        }
        return ans.toString();
    }



    public static void main(String[] args) {
        System.out.println(new Solution1().makeFancyString("leeetcode"));
    }

}
