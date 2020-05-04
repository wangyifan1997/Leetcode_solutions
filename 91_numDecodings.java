// 91. Decode Ways

// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given a non-empty string containing only digits, determine the total number of ways to decode it.

// Example 1:

// Input: "12"
// Output: 2
// Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// Example 2:

// Input: "226"
// Output: 3
// Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int[] dp1 = new int[s.length()];
        int[] dp2 = new int[s.length()];
        dp1[0] = 1;
        dp2[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (isWithin(s.charAt(i - 1), s.charAt(i))) {
                    dp1[i] = dp1[i - 1];
                    dp2[i] = 0;
                } else {
                    return 0;
                }
            } else {
                dp1[i] = dp1[i - 1] + dp2[i - 1];
                dp2[i] = isWithin(s.charAt(i - 1), s.charAt(i)) ? dp1[i - 1] : 0;
            }
        }
        return dp1[s.length() - 1] + dp2[s.length() - 1];
    }
    
    private boolean isWithin(char c1, char c2) {
        if (c1 == '1') return true;
        else if (c1 == '2' && c2 <= 54 && c2 >= 48) return true;
        else return false;
    }
}