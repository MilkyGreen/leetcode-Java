class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        ret = 0
        l = len(nums)

        dict = {}
        sum = 0
        for v in nums:
            dict[sum] = dict.get(sum,0)+1
            sum += v
            ret += dict.get(sum - goal,0)

        return ret