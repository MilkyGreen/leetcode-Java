class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        list = [0 for i in range(1001)]
        
        for trip in trips:
            num = trip[0]
            f = trip[1]
            t = trip[2]
            for i in range(f,t):
                list[i] = list[i] + num
                if list[i] > capacity:
                    return False
        return True
