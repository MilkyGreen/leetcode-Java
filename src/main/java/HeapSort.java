/**
 * 
 */
public class HeapSort {

    public void heapSort(int[] nums){
        buildHeap(nums);
        int l = nums.length;
        for(int i = l-1;i>=0;i--){
            swap(nums,0,i);
            heapify(nums,0,i);
        }
    }

    public void heapify(int[] nums,int n,int l){
        if (n >= l){
            return;
        }
        int c1 = n*2+1;
        int c2 = n*2+2;
        int max = n;
        if(c1 < l && nums[max] < nums[c1]){
            max = c1;
        }

        if(c2 < l && nums[max] < nums[c2]){
            max = c2;
        }
        if(max != n){
            swap(nums,max,n);
            heapify(nums,max,l);
        }
    }

    public void buildHeap(int[] nums){
        int l = nums.length;
        int lastNode = l -1; // 最后一个节点
        int p = (lastNode -1) / 2; // 最后一个父节点
        // 从最后一个父节点开始，依次向前heapify
        for(int i=p;i>=0;i--){
            heapify(nums,i,l);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums ={8,2,4,8,13,2,34,87,43,6};
        new HeapSort().heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
