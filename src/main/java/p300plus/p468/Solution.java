package p300plus.p468;

/**
 * <p>
 */
public class Solution {

    public String validIPAddress(String IP) {
        String v4 = "IPv4";
        String v6 = "IPv6";
        String n = "Neither";

        if(IP.contains(".")){
            return isV4(IP) ? v4 : n;
        }else if(IP.contains(":")){
            return isV6(IP) ? v6 : n;
        }else{
            return n;
        }
    }
    //"172.16.254.1"
    public boolean isV4(String IP){
        if(IP.startsWith(".") || IP.endsWith(".")){
            return false;
        }
        String[] ss = IP.split("\\.");
        if(ss.length != 4){
            return false;
        }
        for(String s : ss){
            if(s.length() > 3 || s.length() == 0 || (s.startsWith("0") && s.length() > 1)){
                return false;
            }
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) > '9' || s.charAt(i) < '0'){
                    return false;
                }
            }
            if(255 < Integer.parseInt(s)){
                return false;
            }
        }
        return true;
    }

    public boolean isV6(String IP){
        if(IP.startsWith(":") || IP.endsWith(":")){
            return false;
        }
        String[] ss = IP.split(":");
        if(ss.length != 8){
            return false;
        }
        for(String s : ss){
            if(s.length() == 0 || s.length() > 4){
                return false;
            }
            for(int i = 0;i<s.length();i++){
                if(!(s.charAt(i) <= 'z' && s.charAt(i) >= 'a') &&!(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') && !(s.charAt(i) <= '9' && s.charAt(i) >= '0')){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validIPAddress("11..5.6"));
    }

}
