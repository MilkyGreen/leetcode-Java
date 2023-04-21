class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        left = 0
        right = len(people) - 1
        ret = 0
        while left <= right:
            lv = people[left]
            rv = people[right]
            if left == right:
                ret += 1
                return ret
            else:
                if rv >= limit:
                    ret += 1
                    right -= 1
                elif lv + rv > limit:
                    ret += 1
                    right -= 1
                else:
                    left += 1
                    right -= 1
                    ret +=1

        return ret
        