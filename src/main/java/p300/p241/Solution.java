package p300.p241;

public class Solution {
    int ADD = -1;
    int MINUS = -2;
    int MULT = -3;
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<>();
        int len = expression.length();
        for(int i = 0;i < len;){
            if(expression.charAt(i) == '+'){
                ops.add(ADD);
                i++;
            }else if(expression.charAt(i) == '-'){
                ops.add(MINUS);
                i++;
            }else if(expression.charAt(i) == '*'){
                ops.add(MULT);
                i++;
            }else{
                int n = 0;
                while(i < len && Character.isDigit(expression.charAt(i))){
                    n = n * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(n);
            }
        }
        int size = ops.size();
        List<Integer>[][] dp = new List[size][size];
        // for (int i = 0; i < ops.size(); i++) {
        //     for (int j = 0; j < ops.size(); j++) {
        //         dp[i][j] = new ArrayList<Integer>();
        //     }
        // }
        return dfs(ops, 0, size-1, dp);
    }

    List<Integer> dfs(List<Integer> ops,int left,int right,List<Integer>[][] dp){
        if(dp[left][right] == null){

            List<Integer> list = new ArrayList<>();
            dp[left][right] = list;

            if(left == right){
                list.add(ops.get(left));
                return list;
            }
            for(int i = left;i < right;i = i + 2){
                List<Integer> lvs = dfs(ops, left, i, dp);
                List<Integer> rvs = dfs(ops, i+2, right, dp);
                for(int lv : lvs){
                    for(int rv : rvs){
                        if(ops.get(i+1) == ADD){
                            list.add(lv + rv);
                        }else if(ops.get(i+1) == MINUS){
                            list.add(lv - rv);
                        }else{
                            list.add(lv * rv);
                        }
                    }
                }
            }
        }
        return dp[left][right];
    }
}
