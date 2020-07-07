package p100.p0064;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * @author yunmeng
 * @version 1.0.0
 */
public class Solution {

    /**
     * 思路：(m,n) 位置的最小路径和 = min((m-1,n)最小路径,(m,n-1)最小路径) + (m,n)的值
     * 需要一次向前递归求上、左位置的最小路径和，取较小的那个加上自身，即为该位置最小路径和
     * 具体做法上，可从最后的位置向前递归，直到起点位置；或者从起点位置遍历数组，依次赋值，最后取值。
     * 本列采用了遍历数组法 -> bug-free 击败98% Java解题。（感觉掌握了动态规划的精髓 :）
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        // 行数
        int row = grid.length;
        // 列数
        int col = grid[0].length;

        // 给第一行赋值，遍历之后数组存的值变成了最小路径和
        // 第一行的路径只能从左边过来，所以直接加上左边的值
        int[] firstRow = grid[0];
        for (int i = 1; i < firstRow.length; i++) {
            firstRow[i] = firstRow[i]+firstRow[i-1];
        }

        // 给第一列赋值，第一列只能从上面过来
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i][0]+grid[i-1][0];
        }

        // 从第二排第二个位置遍历数组，依次赋值。取上、左位置较小的加上自身
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        // 返回最后位置的值
        return grid[row-1][col-1];
    }


}
