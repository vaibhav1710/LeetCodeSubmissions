class Solution {
    public int rob(int[] nums) {
        int ans[][] = new int[nums.length][2];
        ans[0][0] = nums[0];
        ans[0][1]=0;
        for(int i=1;i<nums.length;i++){
            ans[i][0] = ans[i-1][1] + nums[i];
            ans[i][1] = Math.max(ans[i-1][1],ans[i-1][0]);
        }
        return Math.max(ans[ans.length-1][0] , ans[ans.length-1][1]);
    }
}