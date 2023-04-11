//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.dominantPairs(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int dominantPairs(int n, int[] arr) {
      TreeMap<Integer,Integer> tm = new TreeMap<>(Collections.reverseOrder());
      for(int i=0;i<n/2;i++){
          tm.put(arr[i],tm.getOrDefault(arr[i],0)+1);
      }
      int currsum=0;
      for(int v:tm.keySet()){
          currsum += tm.get(v);
          tm.put(v,currsum);
      }
      int ans=0;
      for(int i=n/2;i<n;i++){
          int max = 5*arr[i];
          Integer gg = tm.floorKey(max);
          ans += gg==null?0:tm.get(gg);
      }
      return ans;
    }
}
        
