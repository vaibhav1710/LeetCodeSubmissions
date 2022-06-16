class Solution {
    private String as;
    private String bs;
    private String ss;
    int dp[][][];
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new int [101][101][201];
        as = s1;
        bs = s2;
        ss = s3;
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                for(int l=0;l<201;l++){
                    dp[i][j][l] = -1;
                }
            }
        }
        return solve(0,0,0)==1?true:false;
    }
    
    public int solve(int i,int j,int l){
       if(l==ss.length() && i==as.length() && j==bs.length()){
            return 1;
        }
         
         if(dp[i][j][l]!=-1){
             return dp[i][j][l];
         }
    
        
        if(i<as.length() && j<bs.length() && l<ss.length() && as.charAt(i)==ss.charAt(l) && bs.charAt(j)==ss.charAt(l)){
            return dp[i][j][l] =  solve(i+1,j,l+1)|solve(i,j+1,l+1);
        }
        if(i<as.length() && l<ss.length() && as.charAt(i)==ss.charAt(l)){
            return dp[i][j][l] = solve(i+1,j,l+1);
        }
        if(j<bs.length() && l<ss.length() && bs.charAt(j)==ss.charAt(l)){
            return dp[i][j][l] = solve(i,j+1,l+1);
        }
        
        return dp[i][j][l] = 0;
    }
    
}