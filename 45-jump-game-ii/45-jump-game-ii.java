class Solution {
    public int jump(int[] nums) {
         if(nums.length==1){
             return 0;
         }
         
        if(nums.length==2){
            return 1;
        }
        
        int dp[] = new int[nums.length];
        dp[nums.length-1] = 0;
        for(int i = nums.length-2;i>=0;i--){ 
            int j = nums[i];
            int v= Integer.MAX_VALUE;
            for(int l = i+1;l<=Math.min(i+j,nums.length-1);l++){
                v = Math.min(v,dp[l]);
            }
            if(v == Integer.MAX_VALUE){
                dp[i] = v;
            }else{
            dp[i] = v + 1;
            }
        }
        return dp[0];
    }
}