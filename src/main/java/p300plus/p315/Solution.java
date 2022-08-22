package p300plus.p315;

public class Solution {
    int[] count;
    int[] helper;
    int[] index;
    // 并归排序。 直接对index进行排序
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        
        helper = new int[len];

        index = new int[len];
        count = new int[len];
        for(int i = 0;i < len;i++){
            index[i] = i;
        }
        mergeSort(nums,0,len-1);
        List<Integer> ret = new ArrayList<>();
        for(int i = 0;i < len;i++){
            ret.add(count[i]);
        }
        return ret;
    }

    void mergeSort(int[] nums,int l,int r){
        if(l >= r){
            return;
        }
        int mid = l + ((r - l) >> 1);

        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    void merge(int[] nums,int l,int mid,int r){
        int i = l;
        int j = mid+1;
        int k = l;

        while(i <= mid && j <= r){
            if(nums[index[i]] <= nums[index[j]]){
                helper[k] = index[i];
                // 左边归队的时候，统计j-1到mid-1中间的数量，都能和左边组成逆序对
                count[index[i]] += j - mid - 1;
                k++;
                i++;
            }else{
                helper[k] = index[j];
                k++;
                j++;
            }
        }

        while(i <= mid){
            helper[k] = index[i];
            // 右边空了，那么左边剩下的都比右边的大，都要统计逆序对的数量
            count[index[i]] += j - mid - 1;
            k++;
            i++;
        }

        while(j <= r){
            helper[k] = index[j];
            k++;
            j++;
        }

        for(int m = l;m <= r;m++){
            index[m] = helper[m];
        }

    }
}
