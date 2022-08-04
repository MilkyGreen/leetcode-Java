package p300plus.p321;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ret = null;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i = 0;i <= Math.min(len1,k);i++){
            if(len2 >= k - i){
                int[] max1 = getMax(nums1,i);
                int[] max2 = getMax(nums2,k-i);
                int[] merged = merge(max1, max2);
                if(ret == null){
                    ret = merged;
                }else{
                    if(compareArray(merged,ret,0,0)){
                        ret = merged;
                    }
                }
            }
        }
        return ret;
    }

    int[] getMax(int[] nums,int k){
        int[] ret = new int[k];
        k = nums.length - k;
        LinkedList<Integer> dque = new LinkedList<>();
        for(int n : nums){
            while(dque.size() > 0 && k > 0 && dque.peekLast() < n){
                dque.removeLast();
                k--;
            }
            dque.addLast(n);
        }
        for(int i = 0;i < k;i++){
            dque.removeLast();
        }
        for(int i = 0;i < dque.size();i++){
            ret[i] = dque.get(i);
        }
        return ret;
    }

    int[] merge(int[] nums1,int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ret = new int[len1+len2];

        int i1 = 0;
        int i2 = 0;
        int idx = 0;
        while(i1 < len1 && i2 < len2){
            if(nums1[i1] > nums2[i2]){
                ret[idx] = nums1[i1];
                i1++;
            }else if(nums1[i1] < nums2[i2]){
                ret[idx] = nums2[i2];
                i2++;
            }else{
                if(compareArray(nums1, nums2, i1+1, i2+1)){
                    ret[idx] = nums1[i1];
                    i1++;
                }else{
                    ret[idx] = nums2[i2];
                    i2++;
                }
            }
            idx++;
        }
        if(i1 < len1){
            while(i1 < len1){
                ret[idx] = nums1[i1];
                i1++;
                idx++;
            }
        }
        if(i2 < len2){
            while(i2 < len2){
                ret[idx] = nums2[i2];
                i2++;
                idx++;
            }
        }
        return ret;
    }

    boolean compareArray(int[] nums1,int[] nums2,int i,int j){
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(i >= len1){
            return false;
        }
        if(j >= len2){
            return true;
        }
        if(nums1[i] > nums2[j]){
            return true;
        }else if(nums1[i] < nums2[j]){
            return false;
        }else{
            return compareArray(nums1, nums2, i+1, j+1);
        }
    }
}
