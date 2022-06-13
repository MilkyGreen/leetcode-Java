package p300.p210;

public class Solution2 {
    // 课程 -> 依赖它的课程列表
    Map<Integer,List<Integer>> map = new HashMap<>();
    
    // 0 未遍历 1遍历中 2遍历完成
    Map<Integer,Integer> state = new HashMap<>();
    List<Integer> retList = new ArrayList<>();
    // 已经被添加过的课程
    Set<Integer> added = new HashSet<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for(int[] ps : prerequisites){
            int c = ps[0];
            int pr = ps[1];
            List<Integer> list = map.getOrDefault(pr,new ArrayList<>());
            list.add(c);
            map.put(pr,list);
        }
        LinkedList<Integer> path = new LinkedList<>();
        
        for(int i = 0;i < numCourses;i++){
            if(!dfs(i,path)){
                return new int[0];
            }
        }
        while(path.size() > 0){
            retList.add(path.pop());
        }

        int[] ret = new int[numCourses];
        for(int i = 0;i < numCourses;i++){
            if(!added.contains(i)){
                retList.add(i);
            }
            //ret[i] = retList.get(i);
        }
        
        for(int i = 0;i < numCourses;i++){
            ret[i] = retList.get(i);
        }

        return ret;
    }

    boolean dfs(int c,LinkedList<Integer> stack){
        if(state.containsKey(c)){
            if(state.get(c) == 1){
                return false;
            }else if(state.get(c) == 2){
                return true;
            }
        }
        state.put(c,1);
        if(map.get(c) != null){
            List<Integer> l = map.get(c);
            for(int newc : l){
                if(!dfs(newc,stack)){
                    return false;
                }
            }
        }
        // 这里依赖c的课程都已经被添加到栈里了，再添加c。至于c所依赖的课程，一定是在c后面入栈
        stack.push(c);
        state.put(c,2);
        added.add(c);
        return true;
    }
}
