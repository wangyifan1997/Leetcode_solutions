""" 139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false """

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [None for _ in range(len(s) + 1)]
        dp[0] = True
        return self.memo(s, len(s), dp, wordDict)
        
    def memo(self, s, pos, dp, wordDict):
        if pos < 0:
            return False
        if dp[pos] == None:
            result = False
            for word in wordDict:
                length = len(word)
                result = result or (s[pos - length : pos] == word and self.memo(s, pos - length, dp, wordDict))
            dp[pos] = result
        return dp[pos]