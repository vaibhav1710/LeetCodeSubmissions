class Solution {
     private  final DecimalFormat df = new DecimalFormat("0.00000");
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if((i+1)<k){
                sum += nums[i];
            }else{
                
                 sum += nums[i];
                max = Math.max((sum)/(double)k , max);
                sum -= nums[i-k+1];
               
            }
        }
        df.format(max);
        return max;
    }
}