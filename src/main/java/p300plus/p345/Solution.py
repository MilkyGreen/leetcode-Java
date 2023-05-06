class Solution:
    def reverseVowels(self, s: str) -> str:
        chars = list(s)
        l = len(chars)
        left = 0
        right = l - 1
        while left < right:
            while left < l and not self.isVowel(chars[left]):
                left += 1
            while right >= 0 and not self.isVowel(chars[right]):
                right -= 1
            
            if left < right and self.isVowel(chars[left]) and self.isVowel(chars[right]):
                t = chars[left]
                chars[left] = chars[right]
                chars[right] = t
            left += 1
            right -= 1

        return ''.join(chars)

    def isVowel(self,c):
        if c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u' or c == 'A' or c == 'E' or c == 'I' or c == 'O' or c == 'U':
            return True
        
        return False
        