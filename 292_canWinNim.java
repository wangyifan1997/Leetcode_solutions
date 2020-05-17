// 292. Nim Game

// You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

// Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

// Example:

// Input: 4
// Output: false 
// Explanation: If there are 4 stones in the heap, then you will never win the game;
//              No matter 1, 2, or 3 stones you remove, the last stone will always be 
//              removed by your friend.

class Solution {
    public boolean canWinNim(int n) {
        // if (n <= 3) return true;
        // boolean[] dp = new boolean[n + 1];
        // dp[1] = true;
        // dp[2] = true;
        // dp[3] = true;
        // dp[4] = false;
        // for (int i = 5; i < n + 1; i++) {
        //     dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);
        // }
        // return dp[n];
        
        
        // if (n <= 3) return true;
        // boolean minusThree = true;
        // boolean minusTwo = true;
        // boolean minusOne = true;
        // for (int i = 4; i <= n; i++) {
        //     boolean curr = !(minusThree && minusTwo && minusOne);
        //     if (i == n) return curr;
        //     else {
        //         minusThree = minusTwo;
        //         minusTwo = minusOne;
        //         minusOne = curr;
        //     }
        // } 
        // return false;
        
        return n % 4 != 0;
    }
}