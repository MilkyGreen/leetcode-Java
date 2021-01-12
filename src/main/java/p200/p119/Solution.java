package p200.p119;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     //给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * //
 * //
 * //
 * // 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * //
 * // 示例:
 * //
 * // 输入: 3
 * //输出: [1,3,3,1]
 * //
 * //
 * // 进阶：
 * //
 * // 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class Solution {

    public List<Integer> generate(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex+1 == 0){
            return res;
        }
        for (int i = 1; i <= rowIndex+1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(j == 0){
                    row.add(1);
                }else if(j == i-1){
                    row.add(1);
                }else {
                    row.add(res.get(j-1)+res.get(j));
                }
            }
            res= row;
        }
        return res;
    }


    public static void main(String[] args){
        List<Integer> generate = new Solution().generate(3);
        System.out.println(generate);
    }

}
