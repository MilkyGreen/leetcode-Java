package p200.p120;

public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return triangle.get(0).get(0);
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 1;i < len;i++){
            List<Integer> line = triangle.get(i);
            List<Integer> lastLine = triangle.get(i-1);
            for(int j = 0;j < line.size();j++){
                if(j == 0){
                    line.set(j,line.get(j) + lastLine.get(0));
                }else if(j == line.size() - 1){
                    line.set(j,line.get(j) + lastLine.get(j-1));
                }else{
                    line.set(j,line.get(j) + Math.min(lastLine.get(j-1),lastLine.get(j)));
                }
                if(i == len - 1){
                    ret = Math.min(ret,line.get(j));
                }
            }
        }
        return ret;
    }
}
