package p300plus.p686;

public class Solution {
    public int repeatedStringMatch(String a, String b) {
        int res = 0;
        int len_a = a.length();
        int len_b = b.length();

        char[] a_chars = a.toCharArray();
        char[] b_chars = b.toCharArray();
        int count = len_b / len_a;
        StringBuilder sb = new StringBuilder(a.repeat(count));
        for(int i = 0;i <= 2;i++){
            if(sb.indexOf(b) >= 0){
                return count + i;
            }
            sb.append(a);
        }
        return -1;


    }
}
