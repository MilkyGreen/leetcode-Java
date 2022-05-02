package p300.p296;

import java.util.PriorityQueue;

public class MedianFinder {
    // 两个优先级队列，左边降序，右边升序，奇数时左边多一个，偶数时长度相当
    PriorityQueue<Integer> l = new PriorityQueue<>((a,b) -> b - a);
    PriorityQueue<Integer> r = new PriorityQueue<>((a,b) -> a - b);


    public MedianFinder() {
    }

    public void addNum(int num) {
        if(l.size() == 0){
            l.add(num);
        }else if(r.size() == 0){
            if(l.peek() < num){
                r.add(num);
            }else{
                r.add(l.poll());
                l.add(num);
            }
        }else{
            if(l.size() == r.size()){
                if(r.peek() > num){
                    l.add(num);
                }else{
                    l.add(r.poll());
                    r.add(num);
                }
            }else{
                if(l.peek() < num){
                    r.add(num);
                }else{
                    r.add(l.poll());
                    l.add(num);
                }
            }
        }
    }

    public double findMedian() {
        if(l.size() == r.size()){
            return (double)(l.peek() + r.peek()) / 2;
        }else{
            return l.peek();
        }
    }
}
