package p100.p0010;

/**
 * @author liyunmeng
 * @Description: 正则匹配
 * @Date 2019/12/30 11:08
 */
public class MySolution {

    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
            return s.length() == 0;
        }

        boolean firstMatch = !s.isEmpty() && ((s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s,p.substring(2)) || (firstMatch && isMatch(s.substring(1),p)));
        }else{
            return (firstMatch && isMatch(s.substring(1),p.substring(1)));
        }
    }

    public static void main(String[] args){
        String text = "mississippi";
        String pattern = "mis*is*p*.";
        System.out.println(new MySolution().isMatch(text,pattern));
    }

}
