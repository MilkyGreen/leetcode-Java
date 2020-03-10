package p00012;

/**
 * Created by simon on 2020/2/7.
 */
public class P0012 {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer sb = new StringBuffer();
        int index = 0;
        while (index < 13){

            if(num >= nums[index]){
                sb.append(romans[index]);
                num -= nums[index];
            }else{
                index++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        P0012 p = new P0012();
        System.out.println(p.intToRoman(58));
    }

}
