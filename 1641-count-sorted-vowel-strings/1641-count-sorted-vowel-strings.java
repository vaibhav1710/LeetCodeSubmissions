class Solution {
    public int countVowelStrings(int n) {
        int dp[][] = new int[5][n+1];
        dp[0][1] = 1; // 0 --> a
        dp[1][1] = 1; // 1 --> e
        dp[2][1] = 1; // 2--> i
        dp[3][1] = 1;  // 3--> o
        dp[4][1] = 1;  //  4--> u;
        
        for(int i=2;i<=n;i++){
            for(int j=4;j>=0;j--){
                for(int l=0;l<=j;l++){
                    dp[j][i] += dp[l][i-1];
                }
            }
        }
        int ans = 0;
        for(int i=0;i<5;i++){
            ans += (int)dp[i][n];
        }
        return ans;
    }
}