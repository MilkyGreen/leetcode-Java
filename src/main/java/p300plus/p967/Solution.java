package p300plus.p967;

public class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        if(k == 0 && n == 1){
            return new int[]{0};
        }

        List<int[]> pairs = new ArrayList<>();
        List<List<Integer>> temps = new ArrayList<>();
        Set<Integer> starts = new HashSet<>();

        for(int i = 1;i <= 9;i++){
            if(i >= k){
                if(i-k != 0){
                    starts.add(i-k);
                }
                starts.add(i);
            }
        }

        for(int i : starts){
            List<Integer> l = new ArrayList<>();
            l.add(i);
            temps.add(l);
        }

        for(int i = 1;i < n;i++){
            List<List<Integer>> newTemps = new ArrayList<>();
            for(List<Integer> l : temps){
                if(l.get(i-1) + k <= 9){
                    List<Integer> newl = new ArrayList<>(l);
                    newl.add(l.get(i-1) + k);
                    newTemps.add(newl);
                }
                if(l.get(i-1) - k >= 0 && k != 0 ){
                    List<Integer> newl = new ArrayList<>(l);
                    newl.add(l.get(i-1) - k);
                    newTemps.add(newl);
                }
            }
            temps = newTemps;
        }

        int[] res = new int[temps.size()];
        for(int i =0;i < temps.size();i++){

            List<Integer> l = temps.get(i);
            int sum = 0;
            for(int j : l){
                sum = (sum * 10 + j);
            }
            res[i] = sum;
        }
        return res;
    }
}
