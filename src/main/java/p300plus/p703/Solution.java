package p300plus.p703;

public class Solution {
    int kthNum = Integer.MAX_VALUE;
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        int len = nums.length;
        for(int i : nums){
            pq.add(i);
        }
        for(int i = 0;i < len - k;i++){
            pq.poll();
        }
        if(pq.size() == k){
            kthNum = pq.peek();
        }
    }
    
    public int add(int val) {
        if(kthNum == Integer.MAX_VALUE){
            pq.add(val);
            if(pq.size() == k){
                kthNum = pq.peek();
            }
            return kthNum;
        }else{
            if(val > kthNum){
                pq.add(val);
                pq.poll();
            }
            kthNum = pq.peek();
            return kthNum;
        }
    }
}
