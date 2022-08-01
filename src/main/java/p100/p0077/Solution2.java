package p100.p0077;

public class Solution2 {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k,new LinkedList<Integer>());
        return ret;
    }

    void dfs(int idx,int n,int k,LinkedList<Integer> path){
        if(path.size() == k){
            ret.add(new ArrayList<>(path));
            return;
        }
        if(path.size() + (n - idx + 1) < k){
            return;
        }
        for(int i = idx;i <= n;i++){
            path.addLast(i);
            dfs(i+1,n,k,path);
            path.removeLast();
        }
    }
}
