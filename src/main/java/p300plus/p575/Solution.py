class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        s = set(candyType)
        return min(len(candyType) // 2,len(s))