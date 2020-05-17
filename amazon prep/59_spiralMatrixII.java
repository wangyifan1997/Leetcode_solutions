// 59. Spiral Matrix II

// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// Example:

// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

class Solution {
    double centerX, centerY;
    
    public int[][] generateMatrix(int n) {
        centerX = (n - 1) / 2.0;
        centerY = (n - 1) / 2.0;
        int[][] result = new int[n][n];
        int lastX = -1;
        int lastY = -1;
        for (int i = 1; i <= n * n; i++) {
            int[] curr = getNextPos(lastX, lastY, n);
            result[curr[1]][curr[0]] = i;
            lastX = curr[0];
            lastY = curr[1];
        }
        return result;
    }
    
    private int[] getNextPos(int x, int y, int n) {
        if (x == -1 && y == -1) return new int[] {0, 0};
        // if the current position is on vertex
        if (x == y || x + y + 1 == n) {
            if (x < centerX && y < centerY) {
                return new int[] {x + 1, y};
            } else if (x > centerX && y < centerY) {
                return new int[] {x, y + 1};
            } else if (x < centerX && y > centerY) {
                return new int[] {x, y - 1};
            } else {
                return new int[] {x - 1, y};
            }
        } else {
            if (x > y && x + y + 1 < n) {
                return new int[] {x + 1, y};
            } else if (x > y && x + y + 1 > n) {
                return new int[] {x, y + 1};
            } else if (x < y && x + y + 1 > n) {
                return new int[] {x - 1, y};
            } else {
                if (x + 1 == y) { // special case, turn into the smaller spiral
                    return new int[] {x + 1, y};
                } else {
                    return new int[] {x, y - 1};
                }
            }
        }
    }
}