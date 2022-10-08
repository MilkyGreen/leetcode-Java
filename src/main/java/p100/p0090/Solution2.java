package p100.p0090;

public class Solution2 {
    int[] nums;
    boolean[] vs;
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        vs = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        ret.add(new ArrayList());
        dfs(path,0);
        return ret;
    }

    public void dfs(LinkedList<Integer> path,int idx){

        if(idx >= this.nums.length){
            return;
        }

        for(int i = idx;i < this.nums.length;i++){

            if(i > 0 && this.nums[i] == this.nums[i-1] && !this.vs[i-1]){
                continue;
            }

            path.addLast(this.nums[i]);
            this.vs[i] = true;

            ret.add(new ArrayList<>(path));

            dfs(path,i+1);

            path.removeLast();
            this.vs[i] = false;
        }

    }
}
