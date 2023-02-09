package p300plus.p1462;

public class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 0;i < prerequisites.length;i++){
            int[] prerequisite = prerequisites[i];
            int pre = prerequisite[0];
            int course = prerequisite[1];

            List<Integer> list = graph.getOrDefault(course,new ArrayList<>());
            list.add(pre);
            graph.put(course,list);
        }
        Map<Integer,Set<Integer>> preMap = new HashMap<>();
        for(int i = 0;i < numCourses;i++){
            findPres(i, graph, preMap);
        }
        List<Boolean> ret = new ArrayList<>();
        for(int i = 0;i < queries.length;i++){
            int[] query = queries[i];
            int course = query[1];
            int pre = query[0];
            Set<Integer> set = preMap.get(course);
            if(set != null && set.contains(pre)){
                ret.add(true);
            }else{
                ret.add(false);
            }
        }
        return ret;
    }

    Set<Integer> findPres(int course,Map<Integer,List<Integer>> graph,Map<Integer,Set<Integer>> preMap){
        if(preMap.containsKey(course)){
            return preMap.get(course);
        }
        if(graph.containsKey(course)){
            List<Integer> list = graph.get(course);
            Set<Integer> set = new HashSet<>();
            set.addAll(list);
            for(int c : list){
                Set<Integer> subList;
                if(preMap.containsKey(c)){
                    subList = preMap.get(c);
                }else{
                    subList = findPres(c, graph,preMap);
                }
                if(subList != null){
                    set.addAll(subList);
                }
            }
            preMap.put(course,set);
            return set;
        }else{
            return null;
        }
    }
}
