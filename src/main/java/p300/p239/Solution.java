package p300.p239;

import java.util.LinkedList;

/**
 * <p>
 */
public class Solution {

    // 滑动窗口中最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = nums.length;
        int[] ans = new int[l - k +1]; // 答案数组
        LinkedList<Integer> queue = new LinkedList<>(); // 单调队列，保存元素index，里面的值从大到小排列，头元素就是最大值
//        queue.addLast(0);
        for (int i = 0; i < k; i++) {// 初始化队列
            // 每次要加入新元素时，判断前面如果有小于自己的，则全部删除掉。（因为求的是最大值，大元素加入后中间的小元素可以忽略掉）
            while (queue.size() > 0 && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        ans[0] = nums[queue.peek()]; // 第一个窗口的最大值

        for(int i = 1;i < l - k +1;i++){ // 依次计算后面的窗口

            // 判断头接口是否滑出了窗口（每次移动一步，队列中的元素是按index顺序加入的，所以只判断第一个即可，不可能两个元素滑出）
            if(queue.peek() < i){
                queue.removeFirst();
            }

            // 对于新加入的元素，同样把前面比自己小的移除
            while (queue.size() > 0 && nums[queue.peekLast()] <= nums[i+k-1]){
                queue.removeLast();
            }
            queue.addLast(i+k-1);
            // 此时队首就是当前窗口最大值
            ans[i] = nums[queue.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,-1};
        int[] ints = new Solution().maxSlidingWindow(nums, 1);
        System.out.println(ints);
    }
}
