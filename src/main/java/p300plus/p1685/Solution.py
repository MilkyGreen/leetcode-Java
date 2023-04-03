class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        l = len(nums)
        left_sum = []
        left_sum.append(0)
        
        for i in range(1,l):
            diff = nums[i] - nums[i-1]
            left_sum.append(left_sum[i-1] + diff * i)
        
        right_sum = []
        right_sum.append(0)
        for i in range(1,l):
            idx = l - 1 - i
            diff = nums[idx+1] - nums[idx]
            right_sum.append(right_sum[i-1] + diff * i)
        right_sum = list(reversed(right_sum))

        ret = []
        ret.append(right_sum[0])

        for i in range(1,l-1):
            ret.append(left_sum[i] + right_sum[i])

        ret.append(left_sum[l-1])

        return ret
