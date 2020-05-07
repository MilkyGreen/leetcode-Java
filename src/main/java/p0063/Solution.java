package p0063;

/**
 * Created by simon on 2020/5/2.
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 */
public class Solution {

    /**
     * 思路：
     * 先计算最上边和最左边每个方格的路径 -> 遇到1，当前和后面的格子路径数均为0，否则为1，因为这两边都只有一个路径可走。
     * 从[1][1] 开始依次计算方格的可达路径数，如果值是1，则为0. 否则等于上面和左边的方格路径和，而上面和左面的方格第一步都算过了。
     * 循环到最后一个方格，这样每一个方格的路径数都计算过了。
     * 返回最后一个方格的值
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        obstacleGrid[0][0] = 1;

        for (int i = 1; i < c; i++) {
            obstacleGrid[0][i]=(obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1:0;
        }

        for (int i = 1; i < r; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1:0;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] +obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[r-1][c-1];

    }

}
