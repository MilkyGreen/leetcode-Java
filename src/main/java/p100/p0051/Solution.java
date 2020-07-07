package p100.p0051;

import java.util.*;

/**
 * @author liyunmeng
 * @Description: N皇后
 * @Date 2020/4/21 9:26
 */
public class Solution {
    // 已放置主对角线
    Set<Integer> master = new HashSet<>();
    // 已放置次对角线
    Set<Integer> slave = new HashSet<>();
    // 已放置列
    Stack<Integer> stack = new Stack<>();

    int l;

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        if(n == 0){
            return ans;
        }
        l = n;
        backTrace(0);
        return ans;
    }

    private void backTrace(int row){
        if(row == l){
            ans.add(getOneSolution());
            return;
        }
        for (int i = 0; i < l; i++) {
            if(!isUnderAttack(row,i)){
                master.add(row + i);
                slave.add(row - i);
                stack.push(i);

                backTrace(row + 1);

                master.remove(row + i);
                slave.remove(row - i);
                stack.pop();
            }
        }
    }

    /**
     * 根据stack上的皇后位置，绘制完整棋盘。
     * 每次backTrace之后会恢复现场，所以stack上只有这次方案的列数，循环即是所有列位置。
     * @return
     */
    private List<String> getOneSolution(){
        List<String> list = new ArrayList<>();
        for (Integer integer : stack) {

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < l; i++) {
                if(i == integer){
                    stringBuilder.append("Q");
                }else{
                    stringBuilder.append(".");
                }
            }
            // 将皇后的位置改成Q
            list.add(stringBuilder.toString());
        }
        return list;
    }

    /**
     * 判断一个位置是否会被攻击。
     * row不用判断，因为每次都是找新的行放置。
     * stack保存已经放置过的列，不包含则可以放置。
     * master主对角线放置记录，正方形中主对角线上的每一格的 row+col都相等，row+col的值如果已经存在，说明放置过。
     * slave次对角线，与master同理，区别是row-col。
     * 三个方向都没放置过，就可以放置。
     * @param row 行
     * @param col 列
     * @return true被攻击、false安全
     */
    private boolean isUnderAttack(int row,int col){
        return master.contains(row + col) || slave.contains(row - col) || stack.contains(col);
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}
