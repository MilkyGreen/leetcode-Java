class Solution:
    def arrangeCoins(self, n: int) -> int:
        ret = 0
        row = 1
        while(n >= row):
            ret += 1
            n -= row
            row += 1
        return ret
