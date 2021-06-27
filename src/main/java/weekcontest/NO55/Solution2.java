package weekcontest.NO55;

/**
 * <p>
 */
public class Solution2 {

    public String removeOccurrences(String s, String part) {
        if(part == "" || part == null || s == null || s== ""){
            return s;
        }
        int length = part.length();
        int i = s.indexOf(part);
        if(i != -1){
            s = s.substring(0,i) + s.substring(i+length);
            return removeOccurrences(s,part);
        }else {
            return s;
        }
    }

    public static void main(String[] args){
        System.out.println(new Solution2().removeOccurrences("axxxxyyyyb","xy"));
    }

}
