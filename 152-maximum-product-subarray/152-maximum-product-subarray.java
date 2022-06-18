class Solution {
    public int maxProduct(int[] nums) {
        int dp[] = new int[nums.length];
        int pr = 1;
        int npr=1;
        int ans = Integer.MIN_VALUE;
        
     int fns= 0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]<0){
               pr=1;
               npr = npr*nums[i];
               if(fns==0){
                   fns = npr;
                   ans = Math.max(ans,npr);
               }else{
               ans = Math.max(ans,npr);
               ans = Math.max(ans,npr/fns);
                   }
           }else if(nums[i]>0){
                 pr *= nums[i];
                 npr = npr*nums[i];
                ans = Math.max(ans,pr);
               ans = Math.max(ans,npr);
               if(fns!=0){
                   ans = Math.max(ans,npr/fns);
               }
                 
           }else{
               pr=1;
               npr=1;
               fns=0;
               ans = Math.max(ans,0);
           }
       } 
        
        return ans;
    }
}