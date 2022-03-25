package p100.p0008;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/27 9:57
 */
public class Solution {

    public int myAtoi(String s) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        boolean ne = false;
        int numStart = -1;
        int numEnd = -1;
        boolean hasPre = false;
        for(int i = 0;i < s.length();i++){

            if(numStart == -1){
                if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                    if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                        if(hasPre){
                            return 0;
                        }
                        hasPre = true;
                        ne = s.charAt(i) == '-';
                        continue;
                    }else if(s.charAt(i) == ' '){
                        if(hasPre){
                            return 0;
                        }
                        continue;
                    }else{
                        return 0;
                    }
                }else{
                    // 是数字
                    numStart = i;
                    numEnd = i;
                }
            }else{
                if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                    break;
                }else{
                    numEnd = i;
                }
            }
        }

        if(numStart == -1){
            return 0;
        }

        String str = s.substring(numStart,numEnd+1);

        int realStart = -1;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) != '0'){
                realStart = i;
                break;
            }
        }

        if(realStart == -1){
            return 0;
        }

        str = str.substring(realStart);

        if(str.length() > (max + "").length()){
            if(ne){
                return min;
            }else{
                return max;
            }
        }
        long l = ne ? -Long.parseLong(str) : Long.parseLong(str);
        if(ne){
            if(l < (long)min){
                return min;
            }else{
                return (int)l;
            }
        }else{
            if(l > max){
                return max;
            }else{
                return (int)l;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("   -42"));
    }

}
