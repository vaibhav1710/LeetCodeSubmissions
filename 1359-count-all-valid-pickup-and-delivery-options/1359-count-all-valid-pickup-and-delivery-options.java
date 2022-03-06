class Solution {
    public int countOrders(int n) {
        long dp[] = new long[501];
        dp[1]=1;
        dp[2]=6;
        int m = 1000000007;
          
        for(int i=3;i<501;i++){
            int count = i*2 ;
            count--;
            dp[i] = (count*(count+1))/2;
            dp[i] = (dp[i]*dp[i-1])%m;
        }  
        
        return (int)dp[n];
}    
}