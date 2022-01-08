package weekcontest.NO65;

/**
 * <p>
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println();
    }

    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String[] strings = title.split(" ");
        for (String string : strings) {
            int len = string.length();
            if(len == 1 || len == 2){
                sb.append(string.toLowerCase());
            }else{
                sb.append(string.substring(0,1).toUpperCase()).append(string.substring(1).toLowerCase());
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


}
