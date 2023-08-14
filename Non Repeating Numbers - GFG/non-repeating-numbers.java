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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // 11^100 -> 111
        // and=0
        // or=111
        // 111^11 == 100
        // 100
        int ans[] = new int[2];
        int xor = 0;
        long sum = 0l;
        for(int i=0;i<nums.length;i++){
          xor = xor^nums[i];
          sum += nums[i];
        } 
        xor = xor & (-xor); // only rightmost is set
        
        int x1=0;
        int x2=0;
        
        for(int i=0;i<nums.length;i++){
            if((nums[i]&(xor))>0){
                x1 = x1^nums[i];
            }else{
                x2 = x2^nums[i];
            }
        }
        if(x1>x2){
            ans[0]=x2;
            ans[1]=x1;
        }else{
            ans[0]=x1;
            ans[1]=x2;
        }
        return ans;
    }
}