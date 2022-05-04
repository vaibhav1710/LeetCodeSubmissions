class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int val:hm.keySet()){
            int rem = k - val;
            if(hm.containsKey(rem)){
                count += Math.min(hm.get(rem),hm.get(val));
            }
        }
        
        return count/2;
    }
}