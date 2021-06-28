package p100.p0054;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liyunmeng
 * @Description: 螺旋矩阵什么的太烦了，先跳过...
 * @Date 2020/4/22 22:03
 */
public class Solution {

    // 思路：记录每条边的位置，
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0; // 上面未遍历的位置
        int left = 0; // 左边未遍历的位置
        int bottom = matrix.length-1; // 底部未遍历的位置
        int right = matrix[0].length-1; // 右边未遍历的位置
        List<Integer> ans = new LinkedList<>();
        int elm = matrix.length*matrix[0].length; // 总元素数量
        while (elm >= 1){
            for(int i=left;i<=right && elm >=1;i++){ // 先遍历上边
                ans.add(matrix[top][i]);
                elm--;
            }
            top++; // 上面下移

            for(int i = top;i <= bottom && elm>=1;i++){
                ans.add(matrix[i][right]);
                elm--;
            }
            right--;

            for(int i = right;i>=left&& elm>=1;i--){
                ans.add(matrix[bottom][i]);
                elm--;
            }
            bottom--;

            for(int i = bottom;i>=top&& elm>=1;i--){
                ans.add(matrix[i][left]);
                elm--;
            }
            left++;
        }
        return ans;
    }

}
