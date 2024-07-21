class Solution {
    public int minChanges(int[] nums, int k) {
        // 1 0 1 2 4 3
        // 2, 4, 1
        
        // 0, 1, 2 , 3, 3, 6, 5, 4
        // 4, 4, 4, 0
        
        int n = nums.length;
        int ans = n;
        int dif[] = new int[k+1];
        int maxdif[] = new int[k+1];
        
        for(int i=0, j=n-1;i<j;i++,j--){
            int diff = Math.abs(nums[j]-nums[i]);
            int maxdiff = Math.max(Math.max(nums[i],nums[j]) , k-Math.min(nums[i],nums[j]));
            
            dif[diff]++;
            maxdif[maxdiff]++;
            
        }
        
        for(int i=1;i<=k;i++) maxdif[i] += maxdif[i-1];
        
        for(int i=0;i<=k;i++){
            int two = i>0?maxdif[i-1]:0;
            int one = n/2 - two;
            int ei = dif[i];
            ans = Math.min(ans, 2*two + (one-ei));
        }
        
        return ans;
    }
}