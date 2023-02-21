package p300plus.p969;

public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        List<Integer> ret = new ArrayList<>();
        for(int i = n-1;i >= 0;i--){
            int num = sorted[i];
            int idx = findIdx(arr,num);
            if(idx != i){
                filp(arr,idx+1);
                ret.add(idx+1);

                filp(arr,i+1);
                ret.add(i+1);
            }
        }
        return ret;
    }

    int findIdx(int[] arr,int num){
        for(int i = 0;i < arr.length;i++){
            if(num == arr[i]){
                return i;
            }
        }
        throw new RuntimeException();
    }

    private void filp(int[] arr,int k){
        int left = 0;
        int right = k-1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
