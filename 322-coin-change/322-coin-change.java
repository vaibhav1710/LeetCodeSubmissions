class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            
            for(int j=1;j<dp.length;j++){
              
                if(j<coins[i]){
                    continue;
                }
                if(j-coins[i]>=0 && dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }else{
        return dp[amount];
    }
        
    }     
}