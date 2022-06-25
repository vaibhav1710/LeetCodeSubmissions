class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int cnt=0;
        
         for(int i=0;i<=nums.length-2;i++){
            
            if(nums[i] > nums[i + 1]){
                cnt++;
                if(i>0 && nums[i-1]>nums[i+1]){
                    nums[i+1] = nums[i];
                }else{
                    nums[i]= nums[i+1];
                }
                
            }
            
        }
        
     if(cnt>1){
         return false;
     }
        
        return true;
        
    }
}