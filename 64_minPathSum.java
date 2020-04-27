import java.lang.*;

class Solution {
    int row;
    int col; 
    
    public int minPathSumBackTrackingTimeout(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if (row == 1 && col == 1) return grid[0][0];
        return dfs(grid, 0, 0);
    }
    
    private int dfs(int[][] grid, int x, int y) {
        if (x >= col || y >= row) {
            return Integer.MAX_VALUE;
        } else if (x == col - 1 && y == row - 1) {
            return grid[y][x];
        } else {
            return grid[y][x] + Math.min(dfs(grid, x + 1, y), dfs(grid, x, y + 1));
        }
    }

    public int minPathSumDP(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < row; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[j][i] = grid[j][i] + Math.min(dp[j - 1][i], dp[j][i - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }
}