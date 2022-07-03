class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int prev = nums[1] - nums[0];
        int ans = prev==0?1:2;
        
        for(int i=2;i<nums.length;i++){
            int curr = nums[i]-nums[i-1];
            if((curr>0 && prev<=0) || (curr<0 && prev>=0)){
                ans++;
                prev = curr;
            }
        }
        return ans;
    }
}