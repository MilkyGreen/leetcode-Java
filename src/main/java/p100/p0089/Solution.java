package p100.p0089;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *
 * 格雷编码序列必须以 0 开头。
 *
 */
public class Solution {

    /**
     * 思路：全排列+二进制转10进制？
     * 结果：失败了，题目要求两个连续的数值只有一位数差异，下面的解法不行。解题看了都比较无趣，不想研究了。。。
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n == 0){
            res.add(0);
        }else {
            List<Deque<Integer>> binRes = new ArrayList<>();
            Deque<Integer> path = new ArrayDeque<>();
            dfs(path,n,binRes);
            for (Deque<Integer> binRe : binRes) {
                int i = bin2Ten(binRe);
                res.add(i);
            }
        }
        return res;
    }

    private void dfs(Deque<Integer> path,int n,List<Deque<Integer>> binRes){
        if(path.size() == n){
            Deque<Integer> integers = new ArrayDeque<>(path);
            binRes.add(integers);
        }else {
            path.addLast(0);
            dfs(path,n,binRes);
            path.removeLast();

            path.addLast(1);
            dfs(path,n,binRes);
            path.removeLast();
        }
    }

    // 二级制转10进制
    private int bin2Ten(Deque<Integer> path){
        int ans = 0;
        int bit = 1;
        int size = path.size();
        for (int i = 0; i < size; i++) {
            Integer integer = path.removeLast();
            if(i == 0){
                ans += integer;
            }else {
                bit *= 2;
                ans += bit*integer;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        List<Integer> integers = solution.grayCode(2);
        integers.size();
    }

}
