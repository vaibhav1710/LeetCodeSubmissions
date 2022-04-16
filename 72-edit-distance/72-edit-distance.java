class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word2.length()+1][word1.length()+1];
        
        for(int i=0;i<=word1.length();i++){
            dp[0][i] = i-0;
        }
        for(int j=0;j<=word2.length();j++){
            dp[j][0] = j-0; 
        }
        
        for(int i=1;i<=word2.length();i++){
            
            for(int j=1;j<=word1.length();j++){
             
            if(word1.charAt(j-1)==word2.charAt(i-1)){
                dp[i][j] = dp[i-1][j-1];
            }else{  
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+1;
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
            }    
            }
        }
        
        return dp[word2.length()][word1.length()];
    }
}