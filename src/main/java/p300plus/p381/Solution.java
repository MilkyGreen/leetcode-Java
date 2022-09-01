package p300plus.p381;

public class Solution {
    List<Integer> list;
    Map<Integer,Set<Integer>> map;

    public RandomizedCollection() {
        list = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> set = map.getOrDefault(val,new HashSet<>());
        set.add(list.size() - 1);
        map.put(val,set);
        return set.size() == 1;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        Set<Integer> set = map.get(val);
        Iterator<Integer> it = set.iterator();
        int i = it.next();
        set.remove(i);

        int lastNum = list.get(list.size() - 1);
        list.set(i,lastNum);

        map.get(lastNum).remove(list.size() - 1);

        if(i < list.size() - 1){
            map.get(lastNum).add(i);
        }

        if(set.size() == 0){
            map.remove(val);
        }

        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
