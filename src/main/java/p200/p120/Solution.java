package p200.p120;

import java.util.List;

/**
 * <p>
 *     //给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * //
 * // 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
 * //正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * //输出：11
 * //解释：如下面简图所示：
 * //   2
 * //  3 4
 * // 6 5 7
 * //4 1 8 3
 * //自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：triangle = [[-10]]
 * //输出：-10
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= triangle.length <= 200
 * // triangle[0].length == 1
 * // triangle[i].length == triangle[i - 1].length + 1
 * // -104 <= triangle[i][j] <= 104
 * //
 * //
 * //
 * //
 * // 进阶：
 * //
 * //
 * // 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 * //
 */
public class Solution {

    int res = Integer.MAX_VALUE;

    /**
     * 思路：遍历？  超时了，需要用动态规划来做。
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        Integer integer = triangle.get(0).get(0);
//        res = integer;
        dfs(triangle,2,integer,0);
        return res;
    }

    private void dfs(List<List<Integer>> triangle,int level,int curr,int pickIndex){
        if(triangle.size() < level){
            res = Math.min(res,curr);
            return;
        }
        List<Integer> integers = triangle.get(level-1);
        dfs(triangle,level+1,curr+integers.get(pickIndex),pickIndex);
        dfs(triangle,level+1,curr+integers.get(pickIndex+1),pickIndex+1);
    }


    /**
     * 思路：f[i][j] 代表第i层第j元素的最小路径
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n]; // f[i][j] 代表第i层第j元素的最小路径

        f[0][0] = triangle.get(0).get(0); // 第一层知道
        // 下面依次求每个元素的最小路径
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i-1][0] + triangle.get(i).get(0); // 最左边的只能是上层的最左边加资金

            for (int j = 1; j < i; j++) {
                // 每个位置的最小路径，上层相邻的两个的最小值加自己
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) + triangle.get(i).get(j);
            }

            f[i][i] = f[i-1][i-1] + triangle.get(i).get(i); // 最右边的只能是上层最右边加自己
        }

        // 最后求最后一层哪个路径和最小
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res,f[n-1][i]);
        }
        return res;
    }

}
