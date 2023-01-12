package p300plus.p1381;

public class CustomStack {
    List<Integer> list = new ArrayList<>();
    int cap = 0;
    int size = 0;
    public CustomStack(int maxSize) {
        cap = maxSize;
    }
    
    public void push(int x) {
        if(size < cap){
            list.add(x);
            size++;
        }
    }
    
    public int pop() {
        if(size == 0){
            return -1;
        }else{
            size--;
            return list.remove(list.size() - 1);
        }
    }
    
    public void increment(int k, int val) {
        for(int i = 0;i < Math.min(k,list.size());i++){
            list.set(i,list.get(i) + val);
        }
    }
}
