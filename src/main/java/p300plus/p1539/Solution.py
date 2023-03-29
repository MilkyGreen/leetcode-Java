class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        idx = 0
        nth = 0
        l = len(arr)
        for i in range(1,max(1001,k + arr[l-1]+1)):
            if arr[idx] != i:
                nth += 1
                if nth == k:
                    return i
            else:
               if idx < l -1:
                   idx += 1
        return 0
        