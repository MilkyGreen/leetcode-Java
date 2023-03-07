package p300plus.p1129;

public class Solution {
    Map<Integer,List<Integer>> redMap = new HashMap<>();
    Map<Integer,List<Integer>> blueMap = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    Set<String> seenByColor = new HashSet<>(); // int + r/b
    

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ret = new int[n];
        Arrays.fill(ret,-1);
        ret[0] = 0;
        seen.add(0);

        if(redEdges != null && redEdges.length > 0){
            for(int[] redEdge : redEdges){
                int a = redEdge[0];
                int b = redEdge[1];
                List<Integer> list = redMap.getOrDefault(a,new ArrayList<>());
                list.add(b);
    
                redMap.put(a,list);
            }
        }
        
        if(blueEdges != null && blueEdges.length > 0){
            for(int[] blueEdge : blueEdges){
                int a = blueEdge[0];
                int b = blueEdge[1];
                List<Integer> list = blueMap.getOrDefault(a,new ArrayList<>());
                list.add(b);
    
                blueMap.put(a,list);
            }
        }
        

        int step = 0;
        List<Integer> redList = new ArrayList<>();
        if(redMap.get(0) != null){
            redList.addAll(redMap.get(0));
        }
        List<Integer> blueList = new ArrayList<>();
        if(blueMap.get(0) != null){
            blueList.addAll(blueMap.get(0));
        }
        while(redList.size() > 0 || blueList.size() > 0){
            step++;
            
            List<Integer> newBlueList = new ArrayList<>();
            List<Integer> newRedList = new ArrayList<>();
            if(redList.size() > 0){
                for(int i = 0;i < redList.size();i++){
                    int r = redList.get(i);
                    if(!seen.contains(r)){
                        seen.add(r);
                        ret[r] = step;
                    }
                    if(!seenByColor.contains(r + "r")){
                        seenByColor.add(r + "r");
                        if(blueMap.get(r) != null){
                            newBlueList.addAll(blueMap.get(r));
                        }
                    }
                }
            }
            

            if(blueList.size() > 0){
                for(int i = 0;i < blueList.size();i++){
                    int r = blueList.get(i);
                    if(!seen.contains(r)){
                        seen.add(r);
                        ret[r] = step;
                    }
                    if(!seenByColor.contains(r + "b")){
                        seenByColor.add(r + "b");
                        if(redMap.get(r) != null){
                            newRedList.addAll(redMap.get(r));
                        }
                    }
                }
            }
            
            redList = newRedList;
            blueList = newBlueList;
        }

        return ret;
    }
}
