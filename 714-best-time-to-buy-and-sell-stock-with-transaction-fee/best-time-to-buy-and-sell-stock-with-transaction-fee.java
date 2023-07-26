class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        //dp[i][0] -> bought state  B S B S B* (1 share)
        // dp[i][1] -> sale state   B S B S (no share)
        dp[0][0] = -1*prices[0];
        for(int i=1;i<prices.length;i++){
            // two option for bought state
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            // similarly for sale state
            dp[i][1] = Math.max(dp[i-1][1], prices[i]+dp[i-1][0]-fee);
        }
       return dp[dp.length-1][1];
    }
}