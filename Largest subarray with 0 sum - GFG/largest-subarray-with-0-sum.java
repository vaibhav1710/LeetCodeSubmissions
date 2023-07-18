//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int pre = 0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            pre += arr[i];
            if(pre==0){
                ans = Math.max(ans,i+1);
            }
            if(hm.containsKey(pre)){
                ans = Math.max(ans, i-hm.get(pre));
            }else{
                hm.put(pre,i);
            }
        }
        return ans;
    }
}