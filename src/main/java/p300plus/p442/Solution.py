class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        ret = []
        for n in nums:
            if n < 0:
                n = -n
            if nums[n-1] < 0:
                ret.append(n)
            else:
                nums[n-1] = -nums[n-1]
        return ret