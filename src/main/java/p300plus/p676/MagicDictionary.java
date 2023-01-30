package p300plus.p676;

public class MagicDictionary {
    Map<Integer,List<String>> lenMap;
    public MagicDictionary() {
        lenMap = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s : dictionary){
            int len = s.length();
            List<String> list = lenMap.getOrDefault(len,new ArrayList<>());
            list.add(s);
            lenMap.put(len,list);
        }
    }
    
    public boolean search(String searchWord) {
        int len = searchWord.length();
        if(lenMap.containsKey(len)){
            List<String> list = lenMap.get(len);
            for(String s : list){
                if(isMagic(searchWord,s)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean isMagic(String a,String b){
        int diff = 0;
        for(int i = 0;i < a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
                if(diff >= 2){
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
