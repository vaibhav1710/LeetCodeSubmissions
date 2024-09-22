class Solution {
    public int maxProduct(int[] nums) {
       
       int max1 = Integer.MIN_VALUE;
       int max2 =  Integer.MIN_VALUE;

       int pro=1;

       for(int i=0;i<nums.length;i++){
        pro *= nums[i];
        if(max1<pro) max1 = pro;
        if(pro==0) pro=1;
       }

       pro=1;
       
       for(int i=nums.length-1;i>=0;i--){
        pro *= nums[i];
        if(max2<pro) max2 = pro;
        if(pro==0) pro=1;
       }

        return Math.max(max1, max2);

    }
}