class Solution {
    public int distinctSubseqII(String s) {
        HashMap<Character,Integer> h = new HashMap<>();
        int dp[] = new int[s.length()+1];
         
        dp[0] = 1;
        int m = 1000000007;
        for(int i=1;i<dp.length;i++){
           dp[i] = dp[i-1]*2;
            if(dp[i]<0){
                dp[i] += 1_000_000_007;
            }else{
                dp[i] = dp[i]%1000_000_007;
            }
            char c = s.charAt(i-1);
            
            if(h.containsKey(c)){
                int j = h.get(c);
                dp[i] = dp[i] - dp[j-1];
                 if(dp[i]<0){
                dp[i] += 1_000_000_007;
            }else{
                dp[i] = dp[i]%1000_000_007;
            }
                
                
            }
            
            h.put(c,i);
        }
        return dp[s.length()]<0?(dp[s.length()]-1)+1_000_000_007 : (dp[s.length()]-1)%1_000_000_007;
      
    }
}