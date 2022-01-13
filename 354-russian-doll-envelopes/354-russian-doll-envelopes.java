class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,(a,b) -> Integer.compare(a[0],b[0]));
       // Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        
        int dp[] = new int[envelopes.length];
        int omax = 0;
        for(int i=0;i<envelopes.length;i++){
            int max = 0;
            int j=0;
            while(j<i){
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0] ){
                    max = Math.max(dp[j],max);
                }
                j++;
            }
            
            dp[i] = max+1;
            if(dp[i]>omax){
                omax = dp[i];
            }
        }
        
        return omax;
        
    }
}