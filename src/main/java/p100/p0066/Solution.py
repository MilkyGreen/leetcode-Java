class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        l = len(digits)

        needDeal = True
        
        if needDeal:
            for i in range(l-1,-1,-1):
                v = digits[i]
                if needDeal:
                    v += 1
                    if v >= 10:
                        needDeal = True
                        v = v % 10
                        digits[i] = v
                    else:
                        digits[i] = v
                        needDeal = False
                else:
                    return digits
        if needDeal:
            digits.insert(0,1)

        return digits
