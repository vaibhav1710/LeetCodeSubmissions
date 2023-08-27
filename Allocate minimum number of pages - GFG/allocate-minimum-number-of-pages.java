//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int l = 1;
        int r=0;
        if(M>N) return -1;
        for(int i=0;i<A.length;i++){
            r += A[i];
        }
        int ans = -1;
        int sum = r;
        while(l<=r){
            int mid = (l+r)/2;
            if(check(A,mid,M,sum)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    
    public static boolean check(int a[], int mid, int m,int sum){
        int curr=0;
        int cnt=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>mid) return false;
            if(curr+a[i]>mid){
                curr = a[i];
                cnt++;
            }else{
                curr += a[i];
            }
        }
        return cnt<m;
    }
};