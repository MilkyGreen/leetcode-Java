package p300plus.p729;

public class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        end--;
        Integer pre = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if((pre == null || start > map.get(pre)) && (next == null || end < next )){
            map.put(start,end);
            return true;
        }
        return false;
        
    }
}
