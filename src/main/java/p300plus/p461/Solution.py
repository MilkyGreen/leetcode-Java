class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        n = x ^ y
        ret = 0
        while n > 0:
            if (n & 1) == 1:
                ret += 1
            n = n >> 1
        return ret
        