package weekcontest.N057;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * <p>
 */
public class Solution2 {

    public int smallestChair(int[][] times, int targetFriend) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] target = times[targetFriend];
        for (int[] time : times) {
            int come = time[0];
            if(come <= target[0]){
                list.add(time);
            }
        }
        PriorityQueue<Integer> seats = new PriorityQueue<>();
        for (int i = 0; i <= list.size(); i++) {
            seats.add(i);
        }

        HashMap<int[], Integer> sit = new HashMap<>();

        PriorityQueue<int[]> comeQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> leaveQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] ints : list) {
            comeQueue.add(ints);
            leaveQueue.add(ints);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            while (leaveQueue.peek()[1] == i){
                seats.add(sit.get(leaveQueue.poll()));
            }
            if(comeQueue.peek()[0] == i){
                sit.put(comeQueue.poll(),seats.poll());
            }
            if(target[0] == i){
                break;
            }
        }
        return sit.get(target);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> seats = new PriorityQueue<>();
        seats.add(2);
        seats.add(4);
        seats.add(1);
        seats.poll();
        seats.poll();
        seats.add(5);
        seats.add(4);
    }
}
