class Solution {
    public int trap(int[] height) {
        // O(1) sc wala
        
        int lmax = 0;
        int rmax = 0;
        int l = 0;
        int r = height.length-1;
        int n = height.length;
        int thala = 0;
        
        while(l<=r){
            
            lmax = Math.max(lmax,height[l]);
            rmax = Math.max(rmax,height[r]);
            
            if(height[l]<=height[r]){
              thala += Math.min(lmax,rmax) - height[l];
              l++;  
            }else{
              thala += Math.min(lmax,rmax) - height[r];
              r--;  
            }
            
        }
        return thala;
    }
}