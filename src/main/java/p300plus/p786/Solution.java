package p300plus.p786;

public class Solution {
    /**
     * 最小的肯定是 arr[0]/arr[n-1]，因为分子最小分母最大，第二小的呢，可能是 arr[1]/arr[n] ,也可能是arr[0]/arr[n-2] ，利用优先级队列放入初始的值，每次取最小的，然后分子索引加一再放入队列，直到取k次。
     * 相当于每次取完最小的之后，把疑似下一个顺序的放入队列重新排序，这样空间会小很多。
     * @param arr
     * @param k
     * @return
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> 
            (double)arr[a[0]]/arr[a[1]] - (double)arr[b[0]]/arr[b[1]] > 0 ? 1 : -1
        );

        int n = arr.length;
        for(int i = 1;i < n;i++){
            int[] items = new int[2];
            items[0] = 0;
            items[1] = i;
            q.add(items);
        }

        for(int i = 0;i < k-1;i++){
            int[] min = q.poll();
            if(min[0]+1 < min[1]){
                min[0] = min[0]+1;
                q.offer(min);
            }
        }
        return new int[]{arr[q.peek()[0]],arr[q.peek()[1]]};

    }
}
