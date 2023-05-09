class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        l = len(num)

        n = 0
        for i in num:
            n = n * 10 + i
        
        sum = n + k

        ret = []
        while sum > 0 :
            ret.append(sum % 10)
            sum = sum // 10
        
        ret.reverse()
        return ret
        