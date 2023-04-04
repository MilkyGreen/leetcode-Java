class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num == 1:
            return False
        sum = 1
        
        half = num // 2
        for i in range(2,half+1):
            if i * i > num:
                break
            else:
                if num % i == 0:
                    sum += (i + num//i)
        return sum == num
  