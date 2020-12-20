# 647. Palindromic Substrings

# Given a string, your task is to count how many palindromic substrings in this string.

# The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

# Example 1:

# Input: "abc"
# Output: 3
# Explanation: Three palindromic strings: "a", "b", "c".
 

# Example 2:

# Input: "aaa"
# Output: 6
# Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

# Note:

# The input string length won't exceed 1000.

class Solution:
    def countSubstrings(self, s: str) -> int:
        cnt = 0

        for i in range(len(s)):
            cnt += self.expand(s, i, i)
            cnt += self.expand(s, i, i + 1)
            
        return cnt
    
    def expand(self, s: str, left: int, right: int) -> int:
        cnt = 0
        length = len(s)
        
        while left >= 0 and right < length:
            if s[left] != s[right]:
                break
            
            cnt += 1
            left -= 1
            right += 1
        
        return cnt

    def countSubstringsDP(self, s: str) -> int:
        cnt = 0
        length = len(s)

        dp = [[False for _ in range(length)] for _ in range(length)]

        for k in range(length):
            for i in range(length):
                if k == 0:
                    dp[i][i + k] = True
                    cnt += 1
                else:
                    if i + k >= length:
                        break

                    if k == 1:
                        dp[i][i + k] = (s[i] == s[i + k])
                    else:
                        dp[i][i + k] = (dp[i + 1][i + k - 1] and s[i] == s[i + k])

                    cnt += 1 if dp[i][i + k] else 0
        
        return cnt

    def countSubstringsMemo(self, s: str) -> int:
        cnt = 0
        length = len(s)

        memo = [[None for _ in range(length)] for _ in range(length)]

        for i in range(length):
            for j in range(i, length):
                cnt += 1 if self.memoize(s, memo, i, j) else 0
        
        return cnt
    
    def memoize(self, s, memo, i, j):
        if memo[i][j] is not None:
            return memo[i][j]

        if i == j:
            memo[i][j] = True
        
        elif j == i + 1:
            memo[i][j] = s[i] == s[j]

        else:
            memo[i][j] = self.memoize(s, memo, i + 1, j - 1) and s[i] == s[j]
        
        return memo[i][j]

        
class Solution:
    memo = None
    cnt = 0
    
    def countSubstrings(self, s: str) -> int:
        length = len(s)
        self.memo = [[None for _ in range(length)] for _ in range(length)]
        cnt = 0

        for i in range(length):
            for j in range(i, length):
                cnt += 1 if self.memoize(s, i, j) else 0
        
        return cnt
    
    def memoize(self, s: str, i: int, j: int) -> bool:
        if self.memo[i][j] is not None:
            return self.memo[i][j]

        if i == j:
            self.memo[i][j] = True
        
        elif j == i + 1:
            self.memo[i][j] = s[i] == s[j]

        else:
            self.memo[i][j] = self.memoize(s, i + 1, j - 1) and s[i] == s[j]
        
        return self.memo[i][j]