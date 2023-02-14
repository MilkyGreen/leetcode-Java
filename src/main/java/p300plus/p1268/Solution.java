package p300plus.p1268;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products,(s1,s2) -> s1.compareTo(s2));
        List<List<String>> ret = new ArrayList<>();
        int len = searchWord.length();
        for(int i = 0;i < len;i++){
            String s = searchWord.substring(0,i+1);
            List<String> list = new ArrayList<>();
            for(String p : products){
                if(p.startsWith(s)){
                    list.add(p);
                    if(list.size() == 3){
                        break;
                    }
                }
            }
            ret.add(list);
        }
        return ret;
    }
}
