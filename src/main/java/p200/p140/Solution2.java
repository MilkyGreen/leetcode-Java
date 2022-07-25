package p200.p140;

public class Solution2 {
    List<String> ret = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        dfs(s,set,new LinkedList<String>(),0);
        return ret;
    }

    void dfs(String s,Set<String> set,LinkedList<String> path,int start){
        if(start == s.length()){
            ret.add(genStr(path));
            return;
        }
        for(int i = start;i < s.length();i++){
            String sub = s.substring(start,i+1);
            if(set.contains(sub)){
                path.addLast(sub);
                dfs(s,set,path,i+1);
                path.removeLast();
            }
        }
        
    }

    String genStr(LinkedList<String> path){
        StringBuilder sb = new StringBuilder();
        for(String s : path){
            sb.append(" ");
            sb.append(s);
        }
        return sb.substring(1);
    }
}
