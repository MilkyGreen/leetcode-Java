class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        sl = len(s)
        if sl == 0:
            return t
        
        t_list = list(t)
        t_list.sort()
        s_list = list(s)
        s_list.sort()

        for i in range(0,sl):
            if s_list[i] != t_list[i]:
                return t_list[i]
            
        return t_list[-1]

