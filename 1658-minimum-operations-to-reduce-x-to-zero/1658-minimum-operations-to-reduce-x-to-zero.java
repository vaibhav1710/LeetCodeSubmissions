class Solution {
    public int minOperations(int[] nums, int x) {
        int start = 0;
        long currsum=0l;
        long sum=0l;
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum < x){
            return -1;
        }else if(sum == x){
            return nums.length;
        }else{
            
            long tar = sum - x;
            int ans = 0;
            for(int i=0;i<nums.length;i++){
                currsum += nums[i];
                while( start<=i && currsum > tar){
                    currsum -= nums[start];
                    start++;
                }
                if(currsum == tar){
                    ans = Math.max(ans,i-start+1);
                }
                
            }
            if(ans==0) return -1;
            else return nums.length-ans;
            
        }
        
    }
}