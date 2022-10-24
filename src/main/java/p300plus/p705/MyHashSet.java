package p300plus.p705;

class MyHashSet {
    BitSet bs;
    public MyHashSet() {
        bs = new BitSet(1000001);
    }
    
    public void add(int key) {
        bs.set(key);
    }
    
    public void remove(int key) {
        bs.clear(key);
    }
    
    public boolean contains(int key) {
        return bs.get(key);
    }
}
