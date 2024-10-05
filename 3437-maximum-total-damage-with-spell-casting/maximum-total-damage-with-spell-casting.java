class Solution {
    public long maximumTotalDamage(int[] p) {
        int n = p.length;
        long dp[] = new long[p.length];
        Arrays.sort(p);
        TreeMap<Integer,Long> tm = new TreeMap<>();
        dp[0] = p[0];
        tm.put(p[0],dp[0]);
        long ans = p[0]; 
        TreeMap<Integer,Long> tm1  = new TreeMap<>();
        tm1.put(p[0],dp[0]);
        long max = dp[0];

        for(int i=1;i<n;i++){
            if(p[i]==p[i-1]){
                dp[i] += dp[i-1] + p[i];
               // tm.put(p[i],dp[i]);
                //System.out.println(p[i] + " -1> " + dp[i]);
            }else{
                Integer fl = tm.lowerKey(p[i]-2);
                if(fl==null){
                    dp[i] = p[i];
                   // tm.put(p[i],dp[i]);
                }else{
                   // System.out.println("-2> "+fl);
                    dp[i] += p[i] + tm1.get(fl);
                }
                //System.out.println(p[i] + " -2> " + dp[i]);
            }
            max = Math.max(max,dp[i]);
            tm.put(p[i],dp[i]);
            tm1.put(p[i],max);
            ans = Math.max(dp[i],ans);
        } 
        return ans;
    }
}