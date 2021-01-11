package p200.p118;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * //给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * //
 * //
 * //
 * // 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * //
 * // 示例:
 * //
 * // 输入: 5
 * //输出:
 * //[
 * //     [1],
 * //    [1,1],
 * //   [1,2,1],
 * //  [1,3,3,1],
 * // [1,4,6,4,1]
 * //]
 */
public class Solution {

    /**
     * 思路：第m层第n个元素的值，等于第m-1层的 n-1+n 的值
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(j == 0){
                    row.add(1);
                }else if(j == i-1){
                    row.add(1);
                }else {
                    List<Integer> preRow = res.get(i - 2);
                    row.add(preRow.get(j-1)+preRow.get(j));
                }
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args){
        List<List<Integer>> generate = new Solution().generate(5);
        System.out.println(generate);
    }
}
