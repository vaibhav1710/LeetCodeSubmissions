class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidates = 0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidates = nums[i];
                count++;
            }
            
            else{
                count += (nums[i]==candidates ? 1:-1);
            }
        }
        return candidates;
    }
}