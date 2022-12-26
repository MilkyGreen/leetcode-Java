package p300plus.p949;

public class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public String largestTimeFromDigits(int[] arr) {
        dfs(arr,new boolean[4],new LinkedList<Integer>());
        int maxH = -1;
        int maxM = -1;
        for(List<Integer> l : list){
            int hour = l.get(0) * 10 + l.get(1);
            if(hour > 23){
                continue;
            }
            int minute = l.get(2) * 10 + l.get(3);
            if(minute > 59){
                continue;
            }
            if(hour == -1){
                maxH = hour;
                maxM = minute;
            }else if(hour > maxH){
                maxH = hour;
                maxM = minute;
            }else if(hour == maxH){
                if(minute > maxM){
                    maxM = minute;
                }
            }
        }
        if( maxH == -1 ){
            return "";
        }else{
            String ret = "";
            if(maxH < 10){
                ret += "0" + maxH;
            }else{
                ret += maxH;
            }
            ret += ":";
            if(maxM < 10){
                ret += "0" + maxM;
            }else{
                ret += maxM;
            }
            return ret;
        }
        
    }

    private void dfs(int[] arr,boolean[] vs,LinkedList<Integer> path){
        if(path.size() == 4){
            list.add(new ArrayList(path));
            return;
        }
        for(int i = 0;i < 4;i++){
            if(!vs[i]){
                vs[i] = true;
                path.addLast(arr[i]);
                dfs(arr,vs,path);
                path.removeLast();
                vs[i] = false;
            }
        }
    }
}
