// Amazon | OA 2019 | Max Of Min Altitudes

// Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.

// Don't include the first or final entry. You can only move either down or right at any point in time.

// Example 1:

// Input:
// [[5, 1],
//  [4, 5]]

// Output: 4
// Explanation:
// Possible paths:
// 5 → 1 → 5 => min value is 1
// 5 → 4 → 5 => min value is 4
// Return the max value among minimum values => max(4, 1) = 4.
// Example 2:

// Input:
// [[1, 2, 3]
//  [4, 5, 1]]

// Output: 4
// Explanation:
// Possible paths:
// 1-> 2 -> 3 -> 1
// 1-> 2 -> 5 -> 1
// 1-> 4 -> 5 -> 1
// So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
// Return the max of that, so 4.

class Solution {
    public int maxOfMinAltitudes(int[][] alts) {
        int r = alts.length;
        int c = alts[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = Integer.MAX_VALUE; // To avoid the starting point: set it to Integer.MAX_VALUE 
        for (int i = 1; i < c; i++) {
            dp[0][i] = Math.min(alts[0][i], dp[0][i - 1]);
        }
        for (int i = 1; i < r; i++) {
            dp[i][0] = Math.min(alts[i][0], dp[i - 1][0]);
        } 
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                // To avoid the end: use if statement
                if (i == r - 1 && j == c - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(Math.min(dp[i - 1][j], alts[i][j]), Math.min(dp[i][j - 1], alts[i][j]));
                }
            }
        }
        return dp[r - 1][c - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxOfMinAltitudes(new int[][] {{5, 1}, {4, 5}}));  // 4
        System.out.println(sol.maxOfMinAltitudes(new int[][] {{1, 2, 3}, {4, 5, 1}})); // 4
        System.out.println(sol.maxOfMinAltitudes(new int[][] {{6, 7, 8}, {5, 4, 2}, {8, 7, 6}})); // 5
    }
}