//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
   static  int dp[][];
    static int eggDrop(int n, int k) 
	{
	   dp = new int[n+1][k+1];
	   for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
	   
	  return solve(n,k);
	}
	
	public static int solve(int n,int k){
	    
	    if(dp[n][k]!=-1) return dp[n][k];
	   
	    if(k==0 || k==1) return k;
	    
	    if(n==1) return k;
	    
	    int min = Integer.MAX_VALUE;
	    
	    for(int j=1;j<=k;j++){
	        int res = Math.max(solve(n,k-j),solve(n-1,j-1));
	        if(res<min){
	            min = res;
	        }
	    }
	    
	   return dp[n][k] = min+1;
	}
	
}