package p300plus.p1424;

public class Solution {
    /**
     * 这题不超时的精髓在于不遍历空白的区域，利用同一个对角线 i+j 相等的特性，先排序i+j,同一个对角线里根据j来排序，这样就得到最终的结果
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> res = new ArrayList<>();
        int rows = nums.size();
        for(int i = 0;i < rows;i++){
            List<Integer> list = nums.get(i);
            for(int j = 0;j < list.size();j++){
                res.add(new int[]{i+j,j,list.get(j)});
            }
        }
        res.sort((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else{
                return a[0] - b[0];
            }
        });
        int[] ret = new int[res.size()];
        for(int i=0;i < res.size();i++){
            ret[i] = res.get(i)[2];
        }
        return ret;
    }
}
