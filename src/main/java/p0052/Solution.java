package p0052;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author liyunmeng
 * @Description: N皇后，与51题相同，只返回方案数量
 * @Date 2020/4/21 13:47
 */
public class Solution {

    Set<Integer> master = new HashSet<>();
    Set<Integer> slave = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    int l;
    int ans = 0;

    public int totalNQueens(int n) {
        if(n == 0){
            return ans;
        }
        this.l = n;
        backTrace(0);

        return ans;
    }

    private void backTrace(int row){
        if(row == l){
            ans += 1;
            return;
        }
        for (int i = 0; i < l; i++) {
            if(!isUnderAttack(row,i)){
                master.add(row+i);
                slave.add(row - i);
                stack.push(i);

                backTrace(row + 1);

                master.remove(row+i);
                slave.remove(row - i);
                stack.pop();
            }
        }
    }

    private boolean isUnderAttack(int row,int col){
        return master.contains(row+col) || slave.contains(row -col) || stack.contains(col);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }
}
