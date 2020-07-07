package p100.p0004;

/**
 * @author liyunmeng
 * @Description:
 * @Date 2019/12/23 15:33
 */
public class MySolution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int left = (length1+length2+1)/2;
        int right = (length1+length2+2)/2;

        int kthLeft = findKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, left);
        int kthRight = findKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, right);
        return (kthLeft+kthRight)*0.5;
    }

    /**
     * 从两个已排序数组中查找第k小的数字
     * @param nums1 数组1
     * @param start1 数组1开始位置
     * @param end1 数组1结束位置
     * @param nums2 数组2
     * @param start2 数组2开始位置
     * @param end2 数组2结束位置
     * @param k 第K小
     * @return 目标值
     */
    private int findKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){

        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        // 确保len1是短的
        if(len1 > len2){
            return findKth(nums2,start2,end2,nums1,start1,end1,k);
        }
        // num1空了，直接找num2里面第k小
        if(len1 == 0){
            return nums2[k + start2 - 1];
        }

        // k=1时，返回最左边两个数的最小值
        if(k == 1){
            return Math.min(nums1[start1],nums2[start2]);
        }

        int i = start1+ Math.min(len1,k/2) - 1;
        int j = start2+ Math.min(len2,k/2) - 1;

        if(nums1[i] < nums2[j]){
            return findKth(nums1,i+1,end1,nums2,start2,end2,k - (i - start1+1));
        }else{
            return findKth(nums1,start1,end1,nums2,j+1,end2,k - (j - start2+1));
        }
    }

    public static void main(String[] args){
//        int[] nums1 = {1,3,4,9};
//        int[] nums2 = {1,2,3,4,5,6,7,8,9,10};
//        int[] nums1 = {1,2};
//        int[] nums2 = {3,4};
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        MySolution solution = new MySolution();
        double v = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(v);
    }

}
