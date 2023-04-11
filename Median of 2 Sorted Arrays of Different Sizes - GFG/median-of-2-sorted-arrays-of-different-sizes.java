//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
      int nums1[] = a;
      int nums2[] = b;
      if(nums1.length>nums2.length){
          return medianOfArrays(m,n,nums2,nums1);
      }

     
      int l=0;
      int r = n;
      int mid_of_sorted_array = (n+m+1)/2;

      while(l<=r){
          int mid = (l+r)/2;
          int leftsize_nums1 = mid;
          int leftsize_nums2 = mid_of_sorted_array - mid;
          int left_nums1 =  leftsize_nums1==0?Integer.MIN_VALUE : nums1[leftsize_nums1 - 1];
          int left_nums2 =  leftsize_nums2==0?Integer.MIN_VALUE : nums2[leftsize_nums2 - 1];;
          int right_nums1 = leftsize_nums1==n?Integer.MAX_VALUE : nums1[leftsize_nums1];
          int right_nums2 = leftsize_nums2==m?Integer.MAX_VALUE : nums2[leftsize_nums2];

          if(left_nums1<=right_nums2 && left_nums2<=right_nums1){
             if((n+m)%2==0){
                return (Math.max(left_nums1,left_nums2)+Math.min(right_nums1,right_nums2))/2.0;
             }else{
                return Math.max(left_nums1, left_nums2);
             }
          }else if(left_nums1>right_nums2){
             r = mid-1; 
          }else{
             l = mid+1;
          }
      }
      return 0.0;
    }
}