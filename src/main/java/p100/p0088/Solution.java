package p100.p0088;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 */
public class Solution {

    /**
     * 思路：合并排序？
     * 代码略繁琐，因为直觉上不想用太多System.arraycopy，有种作弊的感觉。运行结果0ms
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num3 = new int[m];
        System.arraycopy(nums1,0,num3,0,m); // 必须拷贝，因为nums1是作为实际输出的，如果num3=num1,最后输出的是num3的值

        int newLength = m + n;

        int num1Index = 0;
        int num2Index = 0;
        for (int i = 0; i < newLength; i++) {

            if(num1Index <= m -1 && num2Index <= n -1){
                int i1 = num3[num1Index];
                int i2 = nums2[num2Index];
                if(i1 >= i2){
                    num2Index++;
                    nums1[i] = i2;
                }else {
                    nums1[i] = i1;
                    num1Index++;
                }
            }else if(num1Index > m -1 && num2Index <= n -1){
                int i2 = nums2[num2Index];
                num2Index++;
                nums1[i] = i2;
            }else if(num2Index > n -1 && num1Index <= m -1){
                int i1 = num3[num1Index];
                nums1[i] = i1;
                num1Index++;
            }
        }
    }

    public static void main(String[] args){
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};

        Solution solution = new Solution();
        solution.merge(num1,3,num2,3);
    }
}
