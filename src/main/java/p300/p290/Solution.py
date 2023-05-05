class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        list = s.split()
        d = {}
        l = len(pattern)
        seen = set()
        if l != len(list):
            return False
        for i in range(0,l):
            if pattern[i] not in d:
                if list[i] not in seen:
                    seen.add(list[i])
                    d[pattern[i]] = list[i]
                else:
                    return False
            else:
                if d[pattern[i]] != list[i]:
                    return False
        
        return True