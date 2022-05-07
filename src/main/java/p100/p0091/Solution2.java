package p100.p0091;

public class Solution2 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n+1];
        if(s.startsWith("0")){
            return 0;
        }
        f[0] = 1;
        f[1] = 1;
        for(int i = 2;i <= n;i++){

            char pre = s.charAt(i-1-1);
            char curr = s.charAt(i-1);
            if(curr == '0'){
                if(pre == '1' || pre == '2'){
                    f[i] = f[i-2];
                }else{
                    return 0;
                }
            }else if(curr <= '6'){
                if(pre == '1' || pre == '2'){
                    f[i] = f[i-2] + f[i-1];
                }else{
                    f[i] = f[i-1];
                }
            }else{
                if(pre == '1'){
                    f[i] = f[i-2] + f[i-1];
                }else{
                    f[i] = f[i-1];
                }
            }
        }

        return f[n];
    }
}
