class Solution {
    public int maxCoins(int[] nums) {
        // states
        /*
         ith ballon burst kru, toh left mei kya hai... aur right mein kya hai..pta hona chahiye 
         - ek toh hogi ki ith ballon burst kru...toh max kya?
         
         - left mei...agar left burst nhi kiya hai..toh baki se farq nhi padega
         - lets say ek subarray hai,  i.....j 
         - dp[i][j] = iss subarray ka max 
         - agar koi last mei foda toh... uska apan ko kya milega
        */
        
        int nnum[] = new int[nums.length+2];
        nnum[0]=1;
        nnum[nums.length+1]=1;
        
        for(int i=1;i<=nums.length;i++){
            nnum[i] = nums[i-1];
        }
        
        int dp[][] = new int[nums.length+2][nums.length+2];
        
        // sub ki length 1 se N tk hogi
        
        for(int i=1;i<=nums.length;i++){
            
            for(int l=1;l<=nums.length-i+1;l++){
                
                int r = l + i - 1;
                
                // last chuno
                
                for(int last = l; last <= r;last++){
                    
                    dp[l][r] = Math.max(dp[l][r] , 
                                dp[l][last-1] + nnum[l-1]*nnum[last]*nnum[r+1] + dp[last+1][r]
                                       );
                    
                }
                
            }
            
        }
        
        return dp[1][nums.length];
    }
}