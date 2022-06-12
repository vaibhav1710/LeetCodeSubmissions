class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int j=0;
        int max = 0;
        HashSet<Integer> h = new HashSet<>();
        int i=0;
        int sum=0;
        while(i<nums.length){
            if(!h.contains(nums[i])){
                sum += nums[i];
                max = Math.max(max , sum);
                h.add(nums[i]);
                i++;
                
            }else{
             sum -= nums[j];
            max = Math.max(sum,max);
                h.remove(nums[j]);
            j++;   
            }
        }
        
        return max;
    }
}