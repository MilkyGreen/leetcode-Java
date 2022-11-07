package p300plus.p473;

public class Solution {
    int[] nums = new int[4];
    int len = 0;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int ms : matchsticks){
            sum += ms;
        }
        if(sum % 4 != 0){
            return false;
        }
        this.len = sum / 4;
        Arrays.sort(matchsticks);
        return dfs(matchsticks.length-1,matchsticks);
    }

    private boolean dfs(int idx,int[] matchsticks){
        
        if(idx == -1){
            return nums[1] == nums[2] && nums[2] == nums[3] && nums[3] == nums[0];
        }

        for(int i = 0; i < 4;i++){
            if(matchsticks[idx] + nums[i] <= this.len){
                nums[i] += matchsticks[idx];
                if(dfs(idx-1,matchsticks)){
                    return true;
                }
                nums[i] -= matchsticks[idx];
            }
        }
        return false;
    }
}
