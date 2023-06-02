package p300plus.p752;

public class Solution {
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target)){
            return 0;
        }

        Set<String> deads = new HashSet<>();
        for(String str : deadends){
            if("0000".equals(str)){
                return -1;
            }
            deads.add(str);
        }

        Set<String> seen = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        seen.add("0000");
        int step = 0;

        while(queue.size() > 0){
            step++;
            int size = queue.size();
            for(int i = 0;i < size;i++){
                String s = queue.poll();
            
                for(String next : getNexts(s)){
                    if(deads.contains(next) || seen.contains(next)){
                        continue;
                    }

                    if(target.equals(next)){
                        return step;
                    }

                    queue.offer(next);
                    seen.add(next);
                }
            }
            
        }
        return -1;
    }

    private List<String> getNexts(String s){
        List<String> nexts = new ArrayList<>();
        
        for(int i = 0;i < 4;i++){
            char[] cs = s.toCharArray();
            char c = cs[i];
            cs[i] = goForth(c);
            nexts.add(new String(cs));

            cs[i] = goBack(c);
            nexts.add(new String(cs));
        }
        return nexts;
    }

    private char goForth(char c){
        return c == '9' ? '0' : (char)(c + 1);
    }

    private char goBack(char c){
        return c == '0' ? '9' : (char)(c - 1);
    }
}
