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