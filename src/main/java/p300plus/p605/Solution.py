class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        if n == 0:
            return True
        
        l = len(flowerbed)
        if l == 1:
            return n == 1 and flowerbed[0] == 0
        
        if flowerbed[0] == 0 and flowerbed[1] == 0:
            flowerbed[0] = 1
            n -= 1

        for i in range(1,l-1):
            if flowerbed[i] == 0 and flowerbed[i-1] == 0 and flowerbed[i+1] == 0:
                flowerbed[i] = 1
                n -= 1
                if n <= 0:
                    return True

        if flowerbed[l-1] == 0 and flowerbed[l-2] == 0:
            flowerbed[l-1] = 1
            n -= 1
        
        return n <= 0