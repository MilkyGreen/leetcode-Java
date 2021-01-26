package p200.p134;

/**
 * //在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * //
 * // 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * //
 * // 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * //
 * // 说明:
 * //
 * //
 * // 如果题目有解，该答案即为唯一答案。
 * // 输入数组均为非空数组，且长度相同。
 * // 输入数组中的元素均为非负数。
 * //
 * //
 * // 示例 1:
 * //
 * // 输入:
 * //gas  = [1,2,3,4,5]
 * //cost = [3,4,5,1,2]
 * //
 * //输出: 3
 * //
 * //解释:
 * //从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * //开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * //开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * //开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * //开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * //开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * //因此，3 可为起始索引。
 * //
 */
public class Solution {

    /**
     * 思路：找走了一站后剩余汽油最多的站作为开始 -> 不行，只能依次判断了。
     * 满心期待打开解题，没想到官方答案也是这样的，并没有什么高级技巧。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int last = circuit(gas, cost, i);
            if(last != -1){
                return last;
            }
        }
        return res;
    }

    private int circuit(int[] gas, int[] cost,int start){
        int n = gas.length;
        int res = -1;
        // 确定了起点，尝试环一周
        int lastGas = gas[start];
        for (int i = start+1; i < n; i++) {
            lastGas -= cost[i - 1];
            if (lastGas < 0) {
                return res;
            }
            lastGas += gas[i];
        }

        for (int i = 0; i < start; i++) {
            if(i == 0){
                if(lastGas - cost[n-1] < 0){ // 减油
                    return res;
                }
                lastGas -= cost[n-1];
            }else {
                if(lastGas - cost[i-1] < 0){
                    return res;
                }
                lastGas -=  cost[i-1];
            }
            lastGas += gas[i]; // 加油
        }
        if(start == 0){
            return lastGas - cost[n - 1] >= 0 ? start : -1;
        }else {
            return lastGas - cost[start - 1] >= 0 ? start : -1;
        }
    }

    public static void main(String[] args){
        int[] nums1 = {5,5,1,3,4};
        int[] nums2 = {8,1,7,1,1};
        int i = new Solution().canCompleteCircuit(nums1, nums2);
        System.out.println(i);
    }

}
