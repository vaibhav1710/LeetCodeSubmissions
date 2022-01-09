class Solution {
     private  final DecimalFormat df = new DecimalFormat("0.00000");
    public double findMaxAverage(int[] nums, int k) {
        int sum =0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if((i+1)<k){
                sum += nums[i];
            }else{ 
                 sum += nums[i];
                max = Math.max(max,sum);
                sum -= nums[i-k+1];  
            }
        }
       
        return max/1.00/k;
    }
}