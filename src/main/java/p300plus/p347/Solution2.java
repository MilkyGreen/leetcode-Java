package p300plus.p347;

public class Solution2 {
    // 题目要求 O(n log n) 
    // nlogn 复杂度大于 n，小于 2n 相当于执行了n次logn ，因此允许一次遍历（复杂度为 N）和堆排序 (n log k)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(Integer n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        int[][] countArr = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int[] arr = new int[2];
            arr[0] = e.getKey();
            arr[1] = e.getValue();
            countArr[i] = arr;
            i++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(k,(int[] a,int[] b) -> a[1] - b[1]);

        for(int j = 0;j < k;j++){
            pq.add(countArr[j]);
        }

        for(int j = k;j < countArr.length;j++){
            if(pq.peek()[1] < countArr[j][1]){
                pq.poll();
                pq.add(countArr[j]);
            }
        }


        int[] ans = new int[k];
        for(int j = 0;j < k;j++){
            ans[j] = pq.poll()[0];
        }
        return ans;

    }
}
