class Solution {
   public  int deleteAndEarn(int[] nums) {

        int sum[] = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }

       int ans[] = new int[10001];
      ans[0] = sum[0];
      ans[1] = Math.max(sum[0],sum[1]);
      for(int i=2;i<10001;i++){
          ans[i] = Math.max( ans[i-1], ans[i-2]+sum[i]);
      }
      return ans[10000];
    }
}