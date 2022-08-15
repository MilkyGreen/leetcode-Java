package p100.p0067;

public class Solution2 {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        String longS = len1 > len2 ? a : b;
        String shortS = len1 > len2 ? b : a;
        
        StringBuilder sb = new StringBuilder();

        int jw = 0;
        for(int i = 1;shortS.length() - i >= 0;i++){
            int v = (longS.charAt(longS.length() - i) - '0') + (shortS.charAt(shortS.length() - i) - '0') + jw;
            if(v >= 2){
                jw = 1;
                sb.append(v - 2);
            }else{
                sb.append(v);
                jw = 0;
            }
            
        }

        for(int i = longS.length()-shortS.length()-1;i >= 0;i--){
            int v = (longS.charAt(i) - '0') + jw;
            if(v >= 2){
                jw = 1;
                sb.append(v - 2);
            }else{
                
                sb.append(v);
                jw = 0;
            }
        }

        if(jw == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
