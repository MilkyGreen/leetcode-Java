package p300plus.p895;

// 这题与lfu 类似，精髓在于每次push进来的数字，放入freq+1的栈中之后，并不从freq的栈中删除，这样就保留了它在老栈中的顺序。同理被pop之后也不用在freq-1的栈中增加，因为之前的都还在。
public class Solution {
    // maxFreq
    int max = 0;
    // num -> freqs
    Map<Integer,Integer> freqs;
    // freq -> numList
    Map<Integer,LinkedList<Integer>> freqList;
    public FreqStack() {
        max = 0;
        freqs = new HashMap<>();
        freqList = new HashMap<>();
    }
    
    public void push(int val) {
        
        int freq = 1;
        if(freqs.containsKey(val)){
            int oldFreq = freqs.get(val);
            freq = oldFreq + 1;
            freqs.put(val,freq);
        }else{
            freqs.put(val,1);
        }

        LinkedList<Integer> newList = freqList.getOrDefault(freq,new LinkedList<>());
        newList.addLast(val);
        freqList.put(freq,newList);

        if(freq > max){
            max = freq;
        }

    }
    
    public int pop() {
        LinkedList<Integer> list = freqList.get(max);
        int val = list.removeLast();
        
        freqs.put(val,max-1);

        if(list.size() == 0){
            freqList.remove(max);
            max--;
        }

        return val;
    }
}
