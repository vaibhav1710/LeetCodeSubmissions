class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> h = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            h.add(nums[i]);
        }
        int ans=0;
        for(int val:h){
            if(!h.contains(val-1)){
                int len=1;
                while(h.contains(val+len)){
                    len++;
                }
                ans = Math.max(len,ans);
            }
        }
        
        return ans;
    }
}