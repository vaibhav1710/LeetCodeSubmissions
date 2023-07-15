class Solution {
     int dp[][];
    public int uniquePaths(int m, int n) {
    dp = new int[m][n];
    for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);   
     return solve(m-1,n-1);
    }

    public int solve(int m, int n){
        if(m==0) return 1;
        else if(n==0) return 1;

        if(dp[m][n]!=-1) return dp[m][n];

       return  dp[m][n] = solve(m-1,n) + solve(m,n-1);
    }

}