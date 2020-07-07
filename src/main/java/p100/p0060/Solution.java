package p100.p0060;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liyunmeng
 * @Description: 全排列-第K个排列
 * 1、先全排列，再找第k个元素 -> 超时了
 * 2、在每个分支开始都可以算出该分支上的排列数，依次找到第k个排列数即可
 * @Date 2020/4/27 14:50
 */
public class Solution {

    // 记录是否使用过某一元素
    boolean[] used;
    // 记录每一次遍历的路径，也就是一次排列的元素。双端队列方便灵活存取
    Deque path = new ArrayDeque<Integer>();
    // 排列合集
    private int[] factorial;
    int k;

    public String getPermutation(int n, int k) {
        used = new boolean[n+1];
        factorial = new int[n];
        this.k = k;
        // 阶乘数组，保存每一层下面排列的个数。每一层下排列个数=剩下元素的阶乘，如选1，剩下2 3 4，那么以1开头的排列有 3!个
        // 这里0！设置为1
        // 不需要保存factorial[n]，因为它代表了所有排列数，k是不会超过它的，所以没有意义。
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        // 从第一层开始，也就是先选取一个数
        dfs(1,n);
        StringBuilder stringBuilder = new StringBuilder();
        path.forEach(s -> stringBuilder.append(s));
        return stringBuilder.toString();
    }

    private void dfs(int index,int n){
        if(index > n){
            // 到底了，说明找到了第k个排列
            return;
        }
        // 选取index个数之后，剩下的数有多少排列数
        int cnt = factorial[n - index];
        for (int i = 1; i <= n; i++) {
            if(!used[i]){
                // 如果K>该分支排列数，说明第k个不在该分支，将这层剪枝
                if(k > cnt){
                    // 减去前面排除的排列数
                    k -= cnt;
                    continue;
                }

                // k<该分支排列数，说明k在下层某个分支中
                // 先add，表示选取了i，继续往i下面的分支中找
                path.addLast(i);
                used[i] = true;
                // index+1，选择过的数多了一个，继续判断下一层的排列数
                dfs(index+1,n);
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(4,9));
    }
}
