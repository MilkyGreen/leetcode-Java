package p300plus.p378;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left < right){
            int mid = left +((right - left) >> 2);
            if(check(matrix,k,mid,n)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    boolean check(int[][] matrix, int k,int num,int n){
        int i = n-1;
        int j = 0;
        int count = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] <= num){
                count += i+1;
                j++;
            }else{
                i--;
            }
        }
        return count >= k;
    }
}
