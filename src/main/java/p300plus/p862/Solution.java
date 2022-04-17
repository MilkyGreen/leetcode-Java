package p300plus.p862;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // 定义为long，防止超大数据量
        long[] sums = new long[n+1];
        for(int i = 1;i <= n;i++){
            if(nums[i - 1] >= k){
                return 1;
            }
            sums[i] = sums[i-1] + nums[i - 1];
        }
        int ret = Integer.MAX_VALUE;
        // 单调递增的双端队列
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 0;i < sums.length;i++){
            // 如果队尾值比当前大，删除。因为如果将来有个值能和dq.peekLast()组成一个合法区间，
            // 也一定能和sums[i]组成，而且sums[i]更靠后，距离更短。
            while(dq.size() > 0 && sums[i] <= sums[dq.peekLast()]){
                dq.removeLast();
            }

            // 如果sums[i]-sums[dq.peekFirst()] >= k，则更新答案，并且去掉first，
            // 因为即是后面再有能和first组成合法区间的，也不会比i更短了。
            while(dq.size() > 0 && sums[i] - sums[dq.peekFirst()] >= k){
                ret = Math.min(ret,i - dq.removeFirst());
            }

            dq.addLast(i);
        }
        
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
