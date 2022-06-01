class Solution {
    public int[] runningSum(int[] nums) {
        int ans[]  = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i!=0)
            ans[i] = nums[i] + ans[i-1];
            else
            ans[i] = nums[i];
        }
        return ans;
    }
}