class Solution {
    public int maxArea(int[] height) {
        long ans = 0l;
        int i=0;
        int j=height.length-1;
        while(i<j){
            long v = (j-i)*Math.min(height[i],height[j]);
            ans = Math.max(ans,v);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return (int)ans;
    }
}