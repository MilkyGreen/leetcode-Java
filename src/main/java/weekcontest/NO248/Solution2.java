package weekcontest.NO248;

import java.util.Arrays;

/**
 * <p>
 */
public class Solution2 {

    // 超出时间限制
    public int eliminateMaximum2(int[] dist, int[] speed) {
        int ans = 0;
        int n = dist.length;
        int nearest = 0;
        int step2o = dist[0]/speed[0];
        for (int i = 0; i < n; i++) {
            if(dist[i] == 0){
                return ans;
            }
            if(dist[i]/speed[i] < step2o){
                step2o = dist[i]/speed[i];
                nearest = i;
            }
        }
        dist[nearest] = -1;
        ans++;

        while (ans < n){
            nearest = -1;
            step2o = dist[0]/speed[0];
            for (int i = 0; i < n; i++) {
                if(dist[i] != -1){
                    dist[i] = dist[i] - speed[i];
                    if(dist[i] <= 0){
                        return ans;
                    }
                    if(nearest == -1){
                        step2o = dist[i]/speed[i];
                        nearest = i;
                    }else {
                        if(dist[i]/speed[i] < step2o){
                            step2o = dist[i]/speed[i];
                            nearest = i;
                        }else if(dist[i]/speed[i] == step2o && dist[i]%speed[i] < dist[nearest]%speed[nearest]){
                            step2o = dist[i]/speed[i];
                            nearest = i;
                        }
                    }
                }
            }
            dist[nearest] = -1;
            ans++;
        }
        return ans;
    }


    public int eliminateMaximum(int[] dist, int[] speed) {
        int l = dist.length;
        double[] steps = new double[l];
        for (int i = 0; i < l; i++) {
            steps[i] = (double) dist[i]/speed[i];
        }
        Arrays.sort(steps);
        int ans = 0;
        for (int i = 0; i < l; i++) {
            if(steps[i] <= i){
                return ans;
            }
            ans++;
        }
        return ans;
    }


    public static void main(String[] args){
        int[] dist = {46,30,48,6,29,18,50,11,34,16,24,17,3,27,42,39,14};
        int[] speed = {1,6,1,15,1,3,2,3,2,3,11,1,1,1,1,1,1};

        int i = new Solution2().eliminateMaximum(dist, speed);
        System.out.println(i);

//        System.out.println(2/1);
//        System.out.println(3/2);

    }
}
