class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int last = prices[0];
        int profit = 0;
        for (int price: prices) {
            if (price > last) profit += (price - last);
            last = price;
        }
        return profit;
    }
}