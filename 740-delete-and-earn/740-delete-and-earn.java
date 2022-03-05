class Solution {
   public  int deleteAndEarn(int[] nums) {

        int sum[] = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }

       int ans[][] = new int[10001][2];
      ans[1][0] = sum[1];
       ans[1][1] = 0;
       ans[2][0] = sum[2];
       ans[2][1] = Math.max(ans[1][0],ans[1][1]);
       for(int i=3;i<10001;i++){
           ans[i][0] =  ans[i-1][1] + sum[i];
           ans[i][1] = Math.max(ans[i-1][0],ans[i-1][1]);
       }
    
      return Math.max(ans[10000][0],ans[10000][1]);
    }
}