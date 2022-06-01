package p100.p00012;

public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        String one = "I";
        String five = "V";
        String ten = "X";
        while(num > 0){
            int n = num % 10;
            if(i == 2){
                one = "X";
                five = "L";
                ten = "C";
            }else if(i == 3){
                one = "C";
                five = "D";
                ten = "M";
            }else if(i == 4){
                one = "M";
            }

            if(n <= 3 ){
                for(int k = 0;k < n;k++){
                    sb.insert(0,one);
                }
            }else if(n == 4){
                sb.insert(0,one+five);
            }else if(n == 9){
                sb.insert(0,one+ten);
            }else{
                for(int k = 0;k < n-5;k++){
                    sb.insert(0,one);
                }
                sb.insert(0,five);
            }

            num /= 10;
            i++;
        }
        return sb.toString();
    }
}
