package p300plus.p556;

public class Solution {
    public int nextGreaterElement(int n) {
        char[] cs = (n + "").toCharArray();

        // 先从后往前找到第一个非递增元素
        int i = cs.length - 2;
        while(i >= 0 && cs[i + 1] <= cs[i]){
            i--;
        }
        if(i == -1){
            return -1;
        }

        // 找到比i大的最小元素
        int j = cs.length - 1;
        for(int k = j;k > i; k--){
            if(cs[k] > cs[i]){
                j = k;
                break;
            }
        }

        // 交换i和j
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;

        // 后面的元素是递增的，翻转一下变为递减的就是最小值
        int start = i + 1;
        int end = cs.length - 1;
        while(start < end){
            char t = cs[start];
            cs[start] = cs[end];
            cs[end] = t;

            start++;
            end--;
        }

        String s = new String(cs);
        try{
            return Integer.parseInt(s);
        }catch(Exception e){
            return -1;
        }
    }
}
