package p300plus.p1438;

public class Solution {
    /**
     * 牛逼啊，竟然做出来了，击败96% Java提交
     * 用滑动窗口确定区间，用两个单调栈确定当前窗口内的最大值和最小值，注意每次left++的时候，看看left是不是在栈顶(栈底，取决于具体数据结构)，如果是需要remove掉，不是就不用管。
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        // 递增，第一个是最小的
        LinkedList<Integer> minStack = new LinkedList<>();
        // 递减，第一个是最大的
        LinkedList<Integer> maxStack = new LinkedList<>();
        int left = 0;
        int right = 0;
        int ret = 0;
        int max = nums[left];
        int min = nums[left];
        while(right < len){
            int r = nums[right];
            while(minStack.size() > 0 && nums[minStack.getLast()] > r){
                minStack.removeLast();
            }
            minStack.addLast(right);

            while(maxStack.size() > 0 && nums[maxStack.getLast()] < r){
                maxStack.removeLast();
            }
            maxStack.addLast(right);
            
            max = nums[maxStack.getFirst()];
            min = nums[minStack.getFirst()];
            if(max - min <= limit){
                ret = Math.max(ret,right - left + 1);
            }else{
                while(left < right){
                    if(left == minStack.getFirst()){
                        minStack.removeFirst();
                    }
                    if(left == maxStack.getFirst()){
                        maxStack.removeFirst();
                    }
                    left++;
                    max = nums[maxStack.getFirst()];
                    min = nums[minStack.getFirst()];
                    if(max - min <= limit){
                        break;
                    }
                }
            }
            right++;
        }
        return ret; 
    }
}
