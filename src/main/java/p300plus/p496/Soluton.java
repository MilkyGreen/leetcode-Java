class Solution {
    // 单调栈记录每个元素的下个元素
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int n : nums2){
            while(stack.size() > 0 && n > stack.peek()){
                int x = stack.pop();
                map.put(x,n);
            }
            stack.push(n);
        }
        while(stack.size() > 0){
            map.put(stack.pop(),-1);
        }
        for(int i=0;i < nums1.length;i++){
            ret[i] = map.get(nums1[i]);
        }

        return ret;
    }
}