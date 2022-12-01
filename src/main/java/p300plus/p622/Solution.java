package p300plus.p622;

public class Solution {
    int[] queue;
    int cap;
    int size;
    int front;
    int rear;
    public MyCircularQueue(int k) {
        this.cap = k;
        this.size = 0;
        queue = new int[k];
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queue[rear] = value;
        rear++;
        size++;
        if(rear == cap){
            rear = 0;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        queue[front] = 0;
        front++;
        size--;
        if(front == cap){
            front = 0;
        }
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int idx = rear - 1;
        if(idx == -1){
            idx = cap - 1;
        }
        return queue[idx];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == cap;
    }
}
