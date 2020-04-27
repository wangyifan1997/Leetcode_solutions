class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = mat[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + mat[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = mat[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        int[][] answer = new int[m][n];
        int upRow;
        int downRow;
        int leftCol;
        int rightCol;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - K - 1 < 0) {
                    leftCol = -1;
                } else {
                    leftCol = j - K - 1;
                }
                if (j + K >= n) {
                    rightCol = n - 1;
                } else {
                    rightCol = j + K;
                }
                if (i - K - 1 < 0) {
                    upRow = -1;
                } else {
                    upRow = i - K - 1;
                }
                if (i + K >= m) {
                    downRow = m - 1;
                } else {
                    downRow = i + K;
                }
                if (leftCol == -1 && upRow == -1) {
                    answer[i][j] = dp[downRow][rightCol];
                } else if (leftCol == -1) {
                    answer[i][j] = dp[downRow][rightCol] - dp[upRow][rightCol];
                } else if (upRow == -1) {
                    answer[i][j] = dp[downRow][rightCol] - dp[downRow][leftCol];
                } else {
                    answer[i][j] = dp[downRow][rightCol] - dp[downRow][leftCol] - dp[upRow][rightCol] + dp[upRow][leftCol]; 
                }    
            }
        }
        return answer;
    }
}