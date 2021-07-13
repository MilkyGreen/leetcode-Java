package p300plus.p1301;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Solution {

    /**
     * E 1 2 4
     * 1 X 1 3
     * 2 1 1 5
     * 2 1 1 S
     * @param board
     * @return
     */
    public int[] pathsWithMaxScore(List<String> board) {
        int mod = (int)Math.pow(10,9) +7;
        int n = board.size();
        int[][][] dp = new int[n][n][2];
        dp[n-1][n-1][1] = 1; // 出发点有一条路径
        // 初始化下、右两条边
        for (int i = n-2; i >=0; i--) {
            dp[i][n-1][0] = board.get(i).charAt(n-1) == 'X' ? -1 : (dp[i+1][n-1][0] == -1 ? -1 : (getInt(board.get(i).charAt(n-1)) + dp[i+1][n-1][0]));
            dp[i][n-1][1] = board.get(i).charAt(n-1) == 'X'? 0 : 1;
            dp[n-1][i][0] = board.get(n-1).charAt(i) == 'X' ? -1 : (dp[n-1][i+1][0] == -1 ? -1 : (getInt(board.get(n-1).charAt(i)) + dp[n-1][i+1][0]));
            dp[n-1][i][1] = board.get(n-1).charAt(i) == 'X' ? 0 : 1;
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if(c == 'X'){
                    dp[i][j][0] = -1;
                }else {
                    int max = Math.max(dp[i + 1][j + 1][0], Math.max(dp[i + 1][j][0], dp[i][j + 1][0]));
                    if (max == -1){
                        dp[i][j][0] = -1;
                    }else {
                        dp[i][j][0] = getInt(c)+ max;
                        if(dp[i + 1][j + 1][0] == max){
                            dp[i][j][1] += dp[i + 1][j + 1][1];
                        }
                        if(dp[i + 1][j][0] == max){
                            dp[i][j][1] += dp[i + 1][j][1];
                        }
                        if(dp[i][j + 1][0] == max){
                            dp[i][j][1] += dp[i][j + 1][1];
                        }
                        dp[i][j][1] %= mod;
                    }
                }
            }
        }
        int sum = dp[0][0][0] == -1 ? 0 : dp[0][0][0];
        int num = dp[0][0][1];
        return new int[]{sum,num};
    }

    private int getInt(char a){
        if (a > 'A'){return 0;}
        return Integer.parseInt(a+"");
    }


    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        /*list.add("E11");
        list.add("XXX");
        list.add("11S");*/

        list.add("E23");
        list.add("2X2");
        list.add("12S");

        /*list.add("E12");
        list.add("1X1");
        list.add("21S");*/

        /*list.add("EX");
        list.add("XS");*/
        new Solution().pathsWithMaxScore(list);
//        System.out.println(Integer.parseInt('1'+"") == 1);
    }
}
