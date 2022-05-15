package p300plus.p400;

/**
 */
public class Solution {

    // 解题关键，先确定目标数字有几位，再找到目标数字，再找数字中的第n位
    // 1到9有9个数字，10 到 99 有100个数字，每个数字长度是2，一共占即100 * 2 ，1000 到 999 一共占 1000*3 ......

    // 1-9      9*1个数字

    // 10~99    90 * 2 个数字

    // 100~999  900 * 3 个数字

    // 1000-9999  9000 * 4 个数字

    // 10000-99999  90000 * 5 个数字
    // .....
    public int findNthDigit(int N) {
        // 转为long避免溢出
        long n = N;
        // i代表当前数字区间有几位
        int i = 1;
        // factor是10的次方
        long factor = 1;

        // 从小的数字开始，依次减去每一个位数的数字数量，直到n小于零，说明n就在刚刚减去的区间里面
        while(n > 0){
            n = n - (9 * factor * i);
            factor = 10 * factor;
            i++;
        }
        // 正好是区间的结束位置，最后一个肯定是9
        if(n == 0){
            return 9;
        }

        // 还原n最后的合法状态
        i--;
        factor /=10;
        n += (9 * factor * i);

        // 目标区间的开始数字
        long start = factor;
        // targetNum 是答案所在的目标数子，i代表每个数字几位，
        long targetNum = start + n / i - 1;
        if(n % i == 0){
            // n正好可以除i，targetNum最后一位就是答案
            return (int)(targetNum % 10);
        }else{
            // 否则targetNum+1,找这个数字的第 n % i 个数字，就是答案
            targetNum++;
            return Integer.parseInt((targetNum + "").toCharArray()[(int)(n % i -1)]+"");
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(1000000000));
    }

}
