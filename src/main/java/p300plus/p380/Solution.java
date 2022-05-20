package p300plus.p380;

public class Solution {
    Random r = new Random();
    Map<Integer,Integer> map;
    // 利用list来常数时间随机方法
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(!contain){
            map.put(val,list.size());
            list.add(val);
        }
        return !contain;
    }
    
    public boolean remove(int val) {
        boolean ret = map.containsKey(val);
        if(ret){
            // 删除时更新list，先把要删除的元素和最后一个元素调换，然后删除，并更新最后一个元素的新索引，实现 O(1)删除
            int idx = map.get(val);
            int last = list.get(list.size() - 1);
            // 下面的顺序很重要，先set，再删除，因为所有的idx都是基于删除前的数量，不能先删除再set
            list.set(idx,last);
            list.remove(list.size() - 1);
            map.put(last,idx);
            map.remove(val);
        }
        
        return ret;
    }
    
    public int getRandom() {
        int i = r.nextInt(map.size());
        return list.get(i);
    }
}
