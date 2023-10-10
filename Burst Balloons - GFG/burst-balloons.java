//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] arr) {
   
       int dp[][] = new int[N+1][N+1];
       
       
       for(int len=1;len<=N;len++){
           
           for(int s=0;s<=N-len;s++){
               int e = s+len-1;
               dp[s][e] = Integer.MIN_VALUE;
               for(int i=s;i<=e;i++){
                   int left = 1;
                   int right=1;
                   int lsum=0;
                   int rsum=0;
                   
                   if(s>0) left = arr[s-1];
                   if(e<N-1) right = arr[e+1];
                   
                   if(i!=s){
                       lsum = dp[s][i-1];
                   }
                   if(i!=e){
                       rsum = dp[i+1][e];
                   }
                   
                   dp[s][e] = Math.max(dp[s][e], lsum + (left*arr[i]*right) + rsum );
               }
               
           }
       }
       
      return dp[0][N-1];
  }
}
     