package p100.p0040;

public class Solution3 {
    int[] candidates;
    int n;
    int target;
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.n = candidates.length;
        this.target = target;
        LinkedList path = new LinkedList<>();
        dfs(0,0,path);
        return ret;
    }

    private void dfs(int i,int sum,LinkedList<Integer> path){
        if(sum == target){
            ret.add(new ArrayList<>(path));
            return;
        }
        if(i == n || sum > target){
            return;
        }
        for(int j = i;j<n;j++){
            if(j > i && candidates[j] == candidates[j-1]){
                continue;
            }
            
            path.addLast(candidates[j]);

            dfs(j+1,sum+candidates[j],path);

            path.removeLast();
            
        }
    }
}
