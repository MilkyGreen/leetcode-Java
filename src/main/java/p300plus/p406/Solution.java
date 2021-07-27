package p300plus.p406;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * <p>
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        int l = people.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int i = 0; i < l; i++) {
            pq.add(people[i]);
        }

        LinkedList<int[]> list = new LinkedList<>();

        // 最大的身高
        int[] p = pq.poll();
        list.add(p);

        int size = pq.size();
        for (int i = 1; i < size; i++) {
            p = pq.poll();
            int higher = p[1];
            int size1 = list.size();
            if(higher == size1){
                list.add(p);
            }else {
                list.add(higher,p);
            }
        }

        for (int i = 0; i < l; i++) {
            people[i] = list.get(i);
        }
        return people;
    }

}
