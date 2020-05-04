// 5. Longest Palindromic Substring

// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

// Example 1:

// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example 2:

// Input: "cbbd"
// Output: "bb"

class Solution {

    // 105ms
    public String longestPalindromeDP(String s) {
        int len = s.length();
        if (len <= 1) return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? true : false;
        }
        for (int k = 2; k < len; k++) {
            for (int i = 0; i + k < len; i++) {
                dp[i][i + k] = dp[i + 1][i + k - 1] && s.charAt(i) == s.charAt(i + k);
            }
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    end = j;
                    start = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    // 22ms
    public String longestPalindromeExpansion(String s) {
        if (s.length() <= 1) return s;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int pos1, int pos2) {
        int left = pos1;
        int right = pos2;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}