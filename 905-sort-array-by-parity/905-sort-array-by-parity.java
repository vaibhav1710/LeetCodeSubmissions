class Solution {
    public int[] sortArrayByParity(int[] nums) {
        Arrays.sort(nums);
        int j = nums.length-1;
        int i=0;
        while(i<j){
        while(j>=0 && nums[j]%2!=0){
                    j--;
                }

                while(i<nums.length && nums[i]%2==0){
                    i++;
                }
         swap(nums,i,j);   
        }
        
        return nums;
    }
    public void swap(int [] a ,int i,int j){
        
        if(i>=j){
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}