class Solution {
    public int oddEvenJumps(int[] arr) {
        boolean dp[][] = new boolean[arr.length][2];
        dp[arr.length-1][0]=dp[arr.length-1][1]=true;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        tm.put(arr[arr.length-1],arr.length-1);
        int n = arr.length;
        int ans=1;
        for(int i=n-2;i>=0;i--){
            Integer odd = tm.ceilingKey(arr[i]);
            if(odd == null){
                dp[i][1] = false;
            }else{
                int ind = tm.get(odd);
                if(dp[ind][0]) dp[i][1] = true;
            }
            
            Integer even = tm.floorKey(arr[i]);
            if(even == null){
                dp[i][0] = false;
            }else{
                 int ind = tm.get(even);
                if(dp[ind][1]) dp[i][0] = true;
            }
            
            if(dp[i][1]) ans++;
            tm.put(arr[i],i);
        }
        return ans;
    }
}