package p300plus.p2047;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 */
public class Solution {

    PriorityQueue<Integer> q;
    public Solution() {
        q = new PriorityQueue<>();
    }

    public void addNum(int num) {
        q.add(num);
    }

    public double findMedian() {
        int n = q.size();
        Integer first = q.peek();
        if(n == 1){
            return first;
        }
        List<Integer> list = new ArrayList<>();
        Integer mid = first;
        for(int i=0;i<=n/2;i++){
            Integer poll = q.poll();
            list.add(poll);
            mid = poll;
            if(i == (n/2)-1){
                first = mid;
            }
        }
        q.addAll(list);
        if(n%2==0){
            return ((double)first+(double)mid) / (double)2;
        }else{
            return (double)mid;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addNum(-5);
        System.out.println(solution.findMedian());
        solution.addNum(-2);
        System.out.println(solution.findMedian());
        solution.addNum(-1);
        System.out.println(solution.findMedian());
        solution.addNum(-4);
        System.out.println(solution.findMedian());
        solution.addNum(-3);
        System.out.println(solution.findMedian());
    }

    /**
     * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
     * [[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
     *
     *
     *
     * [null,null,-1.0,null,-1.5,null,-2.0,null,-2.5,null,-3.0]
     */
}
