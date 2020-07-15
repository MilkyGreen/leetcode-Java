package p100.p0077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 思路：典型的回溯解法。1到n的每个数都可以作为组合的开始，后面又可以跟2到n的所有数，
 * 如果1开头，第二个可以是2到n。2开头则是3到n，所以下个一要加入组合的数才curr+1到n
 * 种可能。以此确定回溯算法。当长度等于k时，找到一个答案，返回递归。
 * Created by simon on 2020/7/15.
 */
public class Solution {

    int n;
    int k;
    List<List<Integer>> result= new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        //每个组合的长度
       this.k = k;
        this.n= n;
        trackBack(1,new LinkedList<>());
        return result;
    }

    private void trackBack(int first,LinkedList<Integer> curr){

        if(curr.size() == k){
            result.add(new LinkedList<>(curr));
            return;
        }

        for (int i = first; i < n+1; i++) {
            curr.add(i);
            trackBack(i+1,curr);
            curr.removeLast();
        }
    }


}
