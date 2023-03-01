package p300plus.p779;

public class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }
        int parent = kthGrammar(n-1,(k+1)/2);
        return k % 2 == 0 ? (1 ^ parent) : parent;
    }
}
