package p300plus.p907;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ret = 0;
        int mod = 1000000000 + 7;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n;i++){
          while(stack.size() > 0 && arr[stack.peek()] > arr[i]){
            stack.pop();
          }
          if(stack.size() == 0){
            left[i] = -1;
          }else{
            left[i] = stack.peek();
          }
          stack.push(i);
        }
        stack.clear();
        for(int i = n-1;i >=0;i--){
          while(stack.size() > 0 && arr[stack.peek()] >= arr[i]){
            stack.pop();
          }
          if(stack.size() == 0){
            right[i] = n;
          }else{
            right[i] = stack.peek();
          }
          stack.push(i);
        }
        for(int i = 0;i < n;i++){
          ret += (long)(i - left[i]) * (right[i] - i) * arr[i];
          ret %= mod;
        }
        return (int)ret;
    }
}
