package p200.p127;

public class Solution {
    Map<String,Integer> words = new HashMap<>();
    int nodeNum = 0;
    List<List<Integer>> edges = new ArrayList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        for(String s : wordList){
            addEdge(s);
        }
        addEdge(beginWord);
        if(!words.containsKey(endWord)){
            return 0;
        }

        LinkedList<Integer> dq = new LinkedList<>();
        int[] dis = new int[nodeNum];
        Arrays.fill(dis,Integer.MAX_VALUE);
        

        int begainId = words.get(beginWord);
        int endId = words.get(endWord);
        dis[begainId] = 0;
        dq.offer(begainId);
        while(dq.size() > 0){
            int wid = dq.poll();
            if(wid == endId){
                return dis[wid] / 2 + 1;
            }
            for(int x : edges.get(wid)){
                if(dis[x] == Integer.MAX_VALUE){
                    dis[x] = dis[wid] + 1;
                    dq.offer(x);
                }
            }
            
        }
        return 0;
    }

    public void addEdge(String word){
        addWord(word);
        int wid1 = words.get(word);
        char[] array = word.toCharArray();
        for(int i = 0;i < array.length;i++){
            char temp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int wid2 = words.get(newWord);
            edges.get(wid1).add(wid2);
            edges.get(wid2).add(wid1);
            array[i] = temp;
        }
    }

    public void addWord(String word){
        if(!words.containsKey(word)){
            words.put(word,nodeNum++);
            edges.add(new ArrayList<>());
        }
    }
}
