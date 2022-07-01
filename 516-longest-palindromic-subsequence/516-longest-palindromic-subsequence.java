class Solution {
    public int longestPalindromeSubseq(String s) {
        
        if(s.length()==1){
            return 1;
        }
        
        int dp[][] = new int[s.length()+1][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(i==0 && j==0){
                    
                }
            }
        }
        
        solve(dp,0,s.length()-1,s);
        return dp[0][s.length()-1];
    }
    
    public int solve(int [][] dp,int l,int r,String s){
        if(l>r){
            return 0;
        }else if(l==r){
            return 1;
        }else if(dp[l][r]!=-1){
            return dp[l][r];
        }
        
        if(s.charAt(l)==s.charAt(r)){
           return dp[l][r] = Math.max(solve(dp,l,r-1,s),Math.max(solve(dp,l+1,r,s),
                                                          2+solve(dp ,l+1,r-1,s)));
        }else{
          return  dp[l][r] =  Math.max(solve(dp,l,r-1,s),Math.max(solve(dp,l+1,r,s),
                                                         solve(dp ,l+1,r-1,s)));
        }
    }
}