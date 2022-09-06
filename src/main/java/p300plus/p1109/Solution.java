package p300plus.p1109;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] ret = new int[n];
        for(int[] booking : bookings){
            ret[booking[0] - 1] += booking[2];
            if(booking[1] < n){
                ret[booking[1]] -= booking[2];
            }
        }
        for(int i = 1;i < n;i++){
            ret[i] += ret[i-1];
        }
        return ret;
    }
}
