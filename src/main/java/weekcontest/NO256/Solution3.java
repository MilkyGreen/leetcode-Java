package weekcontest.NO256;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 */
public class Solution3 {


    public static void main(String[] args) {
        int[] tasks = new int[]{5,6};
        new Solution3().minSessions(tasks,10);
    }


    public int minSessions(int[] tasks, int sessionTime) {
        int sum = 0;
        for (int task : tasks) {
            sum += task;
        }
        if(sum <= sessionTime){
            return 1;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            int n = tasks[i];
            if (n >= sessionTime){
                res += n / sessionTime;
                n %= sessionTime;
            }
            tasks[i] = n;
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        Arrays.sort(tasks);

        for (int i = 0; i < tasks.length; i++) {
            if(map.get(tasks[i]) > 0){
                if(map.containsKey(sessionTime - tasks[i])){
                    if(map.get(sessionTime - tasks[i]) > 0){
                        if(map.get(tasks[i])-1 == 0){
                            map.remove(tasks[i]);
                        }else {
                            map.put(tasks[i],map.get(tasks[i])-1);
                        }
                        if(sessionTime - tasks[i] - 1 ==0 ){
                            map.remove(sessionTime - tasks[i]);
                        }else {
                            if(map.containsKey(sessionTime - tasks[i])){
                                map.put(sessionTime - tasks[i],map.get(sessionTime - tasks[i])-1);
                            }

                        }
                        res++;
                    }
                }else if(map.containsKey(sessionTime*2 - tasks[i])){
                    if(map.get(sessionTime*2 - tasks[i]) > 0){
                        if(map.get(tasks[i])-1 == 0){
                            map.remove(tasks[i]);
                        }else {
                            map.put(tasks[i],map.get(tasks[i])-1);
                        }
                        if(sessionTime*2 - tasks[i] - 1 ==0 ){
                            map.remove(sessionTime*2 - tasks[i]);
                        }else {
                            if(map.containsKey(sessionTime*2 - tasks[i])){
                                map.put(sessionTime*2 - tasks[i],map.get(sessionTime*2 - tasks[i])-1);
                            }

                        }
                        res++;
                    }
                }

            }
        }
        sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        res += sum / sessionTime;
        if(sum % sessionTime != 0){
            res++;
        }
        return res;
    }
}
