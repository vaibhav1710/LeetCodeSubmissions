class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int dp[][] = new int[k+1][piles.size()+1];
        
       for(int i=1;i<=piles.size();i++){   
           dp[1][i] = Math.max(piles.get(i-1).get(0) , dp[1][i-1]);
       }
        
        for(int i=2;i<=k;i++){
            for(int j = 1;j<=piles.size();j++){
                
                int n = Math.min(i,piles.get(j-1).size());
                int sum = 0;
                
                for(int l=0;l<=n;l++){
                    if(l-1>=0){
                        sum += piles.get(j-1).get(l-1);
                                                  
                    }
                    dp[i][j] = Math.max(sum + dp[i-l][j-1], dp[i][j]);
                }
                
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<=piles.size();i++){
            ans  = Math.max(ans, dp[k][i]);
        }
        return ans;
       
    }
}