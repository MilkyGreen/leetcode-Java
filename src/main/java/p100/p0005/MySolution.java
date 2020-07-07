package p100.p0005;

/**
 * @author liyunmeng
 * @Description: 最长相同子串
 * @Date 2019/12/23 20:19
 */
public class MySolution {

    public static void main(String[] args){
        String s = "babad";
        Solution mySolution = new Solution();
        System.out.println(mySolution.longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        String orgin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int maxLen = 0;
        int maxEnd = 0;
        int length = s.length();
        int[][] arr = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(orgin.charAt(i) == reverse.charAt(j)){
                    if(i == 0 || j == 0){
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = arr[i-1][j-1] +1;
                    }
                    if(arr[i][j] > maxLen){
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxLen-maxEnd-1,maxEnd+1);
    }

}
