class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer ord = h.put(nums[i],i);
            if(ord!=null && (i-ord)<=k){
                return true;
            }
        }
        
        return false;
    }
}