//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int dp[][];
    public int total_cost(int[][] cost)
    {
        int n = cost.length;
        dp = new int[n+1][1<<(n)];
        int ans = 1000000000;
        for(int i=1;i<n;i++){
            ans = Math.min(ans,
            cal(i,((1<<n)-1),cost)+cost[i][0]);
        }
        if(ans==1000000000) return 0;
        return ans;
    }
    public int cal(int i, int mask,int cost[][]){
        
        if(Integer.bitCount(mask)==2) return cost[0][i]; 
        if(dp[i][mask]!=0) return dp[i][mask];
        int ans = 1000000000;
        for(int j=0;j<cost.length;j++){
            if(j!=i && j!=0 && ((mask)&(1<<j))!=0){
                ans = Math.min(ans, 
                cal(j,mask & (~(1 << i)) , cost)+cost[j][i]);
            }
        }
    return dp[i][mask]=ans;
    }
}