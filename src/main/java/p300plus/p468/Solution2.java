package p300plus.p468;

public class Solution2 {
    String N = "Neither";
    String V4 = "IPv4";
    String V6 = "IPv6";
    public String validIPAddress(String queryIP) {
        int v4Idx = queryIP.indexOf(".");
        if(v4Idx > 0){
            return v4(queryIP);
        }
        int v6Idx = queryIP.indexOf(":");
        if(v6Idx > 0){
            return v6(queryIP);
        }
        return N;
    }

    String v4(String ip){
        if(ip.startsWith(".") || ip.endsWith(".")){
            return N;
        }
        String[] strs = ip.split("\\.");
        if(strs.length == 4){
            for(String s : strs){
                if(s.length() > 3 || s.length() == 0){
                    return N;
                }

                if(s.length() > 1 && s.startsWith("0")){
                    return N;
                }

                for(int i = 0;i < s.length();i++){
                    if(!isNum(s.charAt(i))){
                        return N;
                    }
                }

                if(Integer.parseInt(s) > 255){
                    return N;
                }
            }
            return V4;
        }
        return N;
    }

    String v6(String ip){
        if(ip.startsWith(":") || ip.endsWith(":")){
            return N;
        }
        String[] strs = ip.split(":");
        if(strs.length == 8){
            for(String s : strs){
                if(s.length() > 4 || s.length() == 0){
                    return N;
                }

                for(int i = 0;i < s.length();i++){
                    if(!isNum(s.charAt(i)) && !isValidA(s.charAt(i))){
                        return N;
                    }
                }
            }
            return V6;
        }
        return N;
    }

    boolean isNum(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }

    boolean isValidA(char c){
        if((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')){
            return true;
        }
        return false;
    }
}
