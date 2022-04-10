package p300plus.p2225;

/**
 */
public class Solution {

    public int maximumCandies(int[] candies, long k) {
        int max= candies[0];
        // int sum = 0;
        for(int c : candies){
            max = Math.max(max,c);
            // sum += c;
        }
        // if(sum < k){
        //     return 0;
        // }
        // if(sum == k){
        //     return 1;
        // }
        int left = 0;
        int right = max;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            long kids = getKids(candies,mid);
            if(kids < k){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return left;
    }

    long getKids(int[] candies,int num){
        long kids = 0;
        for(int c : candies){
            kids += c / num;
        }
        return kids;
    }

}
