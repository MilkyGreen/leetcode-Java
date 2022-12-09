public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        if(x <= arr[0]){
            for(int i = 0;i < k;i++){
                ret.add(arr[i]);
            }
            return ret;
        }else if(x >= arr[arr.length-1]){
            for(int i = arr.length - k;i < arr.length;i++){
                ret.add(arr[i]);
            }
            return ret;
        }else{
            int left = 0;
            int right = arr.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(arr[mid] == x){
                    left = mid - 1;
                    right = mid + 1;
                    // ret.add(x);
                    k--;
                    break;
                }else if(arr[mid] > x){
                    if(arr[mid-1] < x){
                        left = mid - 1;
                        right = mid;
                        break;
                    }else{
                        right = mid - 1;
                    }
                }else{
                    if(arr[mid + 1] > x){
                        left = mid;
                        right = mid + 1;
                        break;
                    }else{
                        left = mid + 1;
                    }
                }
            }
            while(k > 0){
                if(left >= 0 && right < arr.length){
                    if(Math.abs(arr[left] - x) < Math.abs(arr[right] - x)){
                        // ret.add(arr[left]);
                        left--;
                    }else if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
                        // ret.add(arr[right]);
                        right++;
                    }else{
                        // ret.add(arr[left]);
                        left--;
                    }
                }else if(left >= 0){
                    // ret.add(arr[left]);
                    left--;
                }else{
                    // ret.add(arr[right]);
                    right++;
                }
                k--;
            }
            for(int i = left + 1;i < right;i++){
                ret.add(arr[i]);
            }
            return ret;
        }
    }
}
