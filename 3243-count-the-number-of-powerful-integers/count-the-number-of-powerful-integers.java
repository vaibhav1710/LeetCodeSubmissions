class Solution {
    long dp[][];
    int limit;
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        dp = new long[20][2];
        this.limit = limit;

         for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);

        long ans = solve(0,false, ""+(finish+1),s);

         for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        
        ans -= solve(0, false, ""+start, s);
  
        return ans;

    }
 
  public long solve(int i, boolean less, String check, String s) {
    
    if(i==check.length()){
        if(less && i>=s.length()) return 1;
        return 0;
    }

    if(dp[i][less?1:0]!=-1) return dp[i][less?1:0];

    long ans = 0 ;

    int start = 0;
    int end = limit;

    if(i<s.length()){
        start = s.charAt(s.length()-1-i) - '0';
        end = start;
    }

    for(int j=start;j<=end;j++){
        int d = check.charAt(check.length()-1-i)-'0';
        if(j<d){
            ans += solve(i+1,true,check,s);
        }else if(j>d){
            ans += solve(i+1,false,check,s);
        }else{
            ans += solve(i+1,less, check,s);
        }
    }

    return dp[i][less?1:0]=ans;

  }    

}