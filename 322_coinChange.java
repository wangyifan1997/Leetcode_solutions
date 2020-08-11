// 322. Coin Change

// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// Example 1:

// Input: coins = [1, 2, 5], amount = 11
// Output: 3 
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Note:
// You may assume that you have an infinite number of each kind of coin.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] soln = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            soln[i] = -1;
        }
        for (int coin : coins) {
            if (coin <= amount) {
                soln[coin] = 1;
            }
        }
        int min = Arrays.stream(coins).min().getAsInt();
        for (int i = 0; i < min && i < amount + 1; i++) {
            soln[i] = Integer.MAX_VALUE;
        }
        
        coinChangeMemo(coins, amount, soln);

        return soln[amount] == Integer.MAX_VALUE ? -1 : soln[amount];
    }

    private int coinChangeMemo(int[] coins, int amount, int[] soln) {
        if (amount <= 0) {
            return Integer.MAX_VALUE;
        }

        if (soln[amount] == -1) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChangeMemo(coins, amount - coin, soln);
                if (res < min) {
                    min = res;
                }
            }
            soln[amount] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1);
        }

        return soln[amount];
    }
}