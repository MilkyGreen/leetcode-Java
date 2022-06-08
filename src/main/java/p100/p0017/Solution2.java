package p100.p0017;

public class Solution2 {
    List<String> ret = new ArrayList<>();
    char[] ds;
    String digits;
    int len;
    public List<String> letterCombinations(String digits) {
        this.len = digits.length();
        if(this.len == 0){
            return ret;
        }
        this.digits = digits;
        ds = digits.toCharArray();
        dfs(0,new StringBuilder());
        return ret;
    }

    void dfs(int idx,StringBuilder sb){
        if(idx == len){
            ret.add(sb.toString());
            return;
        }
        char[] cs = getCharByNum(ds[idx] - '0');
        for(char c : cs){
            sb.append(c);
            dfs(idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    char[] getCharByNum(int n){
        if(n == 9){
            return new char[]{'w','x','y','z'};
        }
        if(n == 7){
            return new char[]{'p','q','r','s'};
        }
        if(n == 8){
            return new char[]{'t','u','v'};
        }
        char[] res = new char[3];
        res[0] = (char)((int)'a' + (n - 2) * 3);
        res[1] = (char)((int)'a' + ((n - 2) * 3 + 1));
        res[2] = (char)((int)'a' + ((n - 2) * 3 + 2));
        return res;
    }
}
