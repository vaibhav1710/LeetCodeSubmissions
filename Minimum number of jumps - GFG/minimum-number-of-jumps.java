//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        if(arr.length<=1) return 0;
        if(arr[0]==0) return -1;
      int ans = 0;
      int max = arr[0];
      int count = arr[0];
      
      for(int i=1;i<arr.length-1;i++){
          max = Math.max(max, arr[i]+i);
          count--;
          if(count==0){
              if(max<=i) return -1;
              count = max - i;
              ans++;
          }
         
      }
      if(max<arr.length-1) return -1;
      return ans+1;
    }
}