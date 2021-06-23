package p300.p210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 */
public class Solution {

    // 拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>(numCourses); // 课程 -》依赖它的课程列表
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] flags = new int[numCourses]; // 课程搜索状态 0未搜索 1搜索中 2已搜索
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(flags,i,edges,stack)){
                return new int[0];
            }
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public boolean dfs(int[] flags,int courseNum,List<List<Integer>> edges,Deque<Integer> stack){
        if(flags[courseNum] == 1){
            return false;
        }

        if(flags[courseNum] == 2){
            return true;
        }

        flags[courseNum] = 1;
        for (Integer integer : edges.get(courseNum)) {
            if (!dfs(flags,integer,edges,stack)){
                return false;
            }
        }
        flags[courseNum] = 2;
        stack.push(courseNum); // 所有依赖courseNum的课程都已经入栈，courseNum入栈时一定在他们前面
        return true;
    }

    public static void main(String[] args){
        int[] prerequisite = {1,0};
        int[][] prerequisites = {prerequisite};
        new Solution().findOrder(2,prerequisites);
    }
}
