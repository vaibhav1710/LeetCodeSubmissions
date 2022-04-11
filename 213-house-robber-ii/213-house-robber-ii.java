class Solution {
    public int rob(int[] nums) {
         
        if(nums.length==1){
            return Math.max(0,nums[0]);
        }
        else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }else{
        int ans[][] = new int[nums.length][2];
        ans[0][0] = nums[0];
        ans[0][1] = 0;
        int n = nums.length;
            
         // include first house and exclude the last one   
        for(int i=1;i<nums.length-1;i++){
            ans[i][0] = ans[i-1][1]+nums[i];
            ans[i][1] = Math.max(ans[i-1][0],ans[i-1][1]);
        }
        int fans=0;
        fans = Math.max(ans[n-2][0],ans[n-2][1]);
        
        ans = new int[n][2];
        ans[1][0] = nums[1];
        ans[1][1] = 0;
            
          // exclude first house and include the last one 
            
         for(int i=2;i<nums.length;i++){
            ans[i][0] = ans[i-1][1]+nums[i];
            ans[i][1] = Math.max(ans[i-1][0],ans[i-1][1]);
        }
         fans =Math.max(fans , Math.max(ans[n-1][0],ans[n-1][1]));
        
        return fans;
        }
    }
}