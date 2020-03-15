package p0038;

/**
 * @author liyunmeng
 * @Description: 外观数列
 * @Date 2020/3/15 21:38
 */
public class Solution {

    public String countAndSay(int n) {

        String curr = "1";

        return countNext(curr,n - 1);
    }

    public String countNext(String curr,int n){
        if(n == 0){
            return curr;
        }else{
            StringBuilder newCount = new StringBuilder();
            char[] chars = curr.toCharArray();
            int count = 1;
            char currChar = chars[0];
            for (int i = 1; i < chars.length; i++) {
                if(chars[i] == currChar){
                    count++;
                }else{
                    newCount.append(count).append(currChar);
                    count = 1;
                    currChar = chars[i];
                }
            }
            newCount.append(count).append(currChar);
            return countNext(newCount.toString(),n - 1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(5));
    }

}
