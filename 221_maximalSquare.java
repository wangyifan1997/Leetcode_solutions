// 221. Maximal Square

// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

// Example:

// Input: 

// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0

// Output: 4

import java.lang.Math;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        if (matrix[0][0] == '0') {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + (matrix[0][i] == '0'? 0 : 1);
        }
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i - 1][0] + (matrix[i][0] == '0'? 0 : 1);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + (matrix[i][j] == '0'? 0 : 1);
            }
        }
        int len = 0;
        int max = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                } else {
                    for (int k = len + 1; k <= max; k++) {
                        if (get(dp, i, j) - get(dp, i - k, j) - get(dp, i, j - k) + get(dp, i - k, j - k) == (int) Math.pow(k, 2)) {
                            len++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return (int) Math.pow(len, 2);
    }

    private int get(int[][] dp, int row, int col) {
        if (row < 0 || row >= dp.length || col < 0 || col >= dp[0].length) {
            return 0;
        } else {
            return dp[row][col];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] matrix = {{'1', '1', '1', '0', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(sol.maximalSquare(matrix));
    }
}