class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
      
       Arrays.sort(nums);
       for(int i=0;i<nums.length;i++){
           if(i>0 && nums[i]==nums[i-1]) continue;
           
           int j=i+1;
           int l = nums.length-1;
           
           while(j<l){
               int sum = nums[i]+nums[j]+nums[l];
               if(sum>0) l--;
               else if(sum<0) j++;
               else{
                   ans.add(Arrays.asList(nums[i], nums[j], nums[l]));
                   l--;
                   j++;
                   while(j<l && nums[j]==nums[j-1])j++;
                   while(j<l && nums[l]==nums[l+1])l--;
               }
           }
      }
return ans;
}
}