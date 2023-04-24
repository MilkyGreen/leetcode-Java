class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        ret = []
        sum = 0
        for n in nums:
            sum += n
            ret.append(sum)
        return ret