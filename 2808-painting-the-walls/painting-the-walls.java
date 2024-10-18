class Solution {
    int dp[][];
    public int paintWalls(int[] cost, int[] time) {
     
      dp = new int[cost.length][3000];
      for(int i=0;i<cost.length;i++) Arrays.fill(dp[i],-1);
      return solve(0,0,cost.length,cost, time);
    }  

    public int solve(int i, int ext, int n, int c[], int t[]){
        
        if(i==n && ext<0) return 1000000000;
        if(i==n && ext>0) return 0;
        if(ext > (n-i-1)) return 0;
          
        if(dp[i][ext+1500]!=-1) return dp[i][ext+1500];  
        
        
        int ans = 1000000000;
        ans = Math.min(ans, c[i] + solve(i+1, ext + t[i], n, c, t));
        ans = Math.min(ans, solve(i+1, ext-1, n, c, t));

        
        return dp[i][ext+1500]=ans;
    }
}