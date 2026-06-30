class Solution {
    public int maxProfit(int[] prices) {
        int minP = prices[0];
        int maxP = 0;
        for(int i = 0; i < prices.length; i++){
            int currentP = prices[i];
            int profit = currentP - minP;
            maxP = Math.max(maxP,profit);
            minP = Math.min(minP,currentP);
        }
        return maxP;
    }
}
