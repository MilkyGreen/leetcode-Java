package p100.p0006;

public class Solution2 {
    public String convert(String s, int numRows) {
        List<List<Character>> z = new ArrayList<>(numRows);
        int row = 0;
        char[] cs = s.toCharArray();
        boolean godown = true;
        for(int i = 0;i < cs.length;i++){
            if(z.size() < row+1){
                z.add(new ArrayList<>());
            }
            List line = z.get(row);
            line.add(cs[i]);
            if(godown){
                row++;
            }else{
                row--;
            }

            if(row == numRows){
                row -=2;
                godown = false;
            }

            if(row == -1){
                row = 1;
                godown = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(List<Character> l : z){
            for(Character c : l){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
