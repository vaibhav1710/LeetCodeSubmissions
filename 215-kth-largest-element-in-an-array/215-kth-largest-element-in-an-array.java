class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        int ans = -1;
        while(k-->0){
            ans = q.remove();
        }
        return ans;
    }
}