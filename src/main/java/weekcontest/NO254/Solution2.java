package weekcontest.NO254;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 */
public class Solution2 {

    boolean[] flag;
    List<Integer> res = null;
    public int[] rearrangeArray2(int[] nums) {
        int l = nums.length;
        flag = new boolean[l];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums,path);
        int[] ans = new int[l];
        for (int i = 0; i < res.size(); i++) {
            ans[i] =res.get(i);
        }
        return ans;
    }

    private boolean dfs(int[] nums,LinkedList<Integer> path){
        if(path.size() == nums.length){
            res = new ArrayList<>(path);
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!flag[i]){
                if(path.size() <= 1){
                    flag[i] = true;
                    path.add(nums[i]);
                    if(dfs(nums,path)){
                        return true;
                    }
                    flag[i] = false;
                    path.removeLast();
                }else {
                    Integer curr = path.getLast();
                    Integer pre = path.get(path.size() - 2);
                    if(nums[i] + pre!= curr*2){
                        flag[i] = true;
                        path.add(nums[i]);
                        if(dfs(nums,path)){
                            return true;
                        }
                        flag[i] = false;
                        path.removeLast();
                    }
                }
            }
        }
        return false;
    }



    public int[] rearrangeArray(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[l];
        int i = 0;
        int k = l / 2;
        for(int j = 0;j<k;j++){
            ans[i] = nums[j];
            ans[i+1] = nums[l-1-j];
            i=i+2;
        }
        if(l % 2 != 0){
            ans[i] = nums[k];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,4,5};
//        1324;
        int[] ints = new Solution2().rearrangeArray(n);
        System.out.println(ints);
    }
}
