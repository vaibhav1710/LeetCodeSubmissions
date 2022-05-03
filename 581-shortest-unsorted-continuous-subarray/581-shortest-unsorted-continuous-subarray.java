class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int a[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            a[i] = nums[i];
        }
        Arrays.sort(a);
        int j=0;
        int i = nums.length-1;
        
        while(j<nums.length && a[j]==nums[j]){
            j++;
        }
        while(i>=0 && a[i]==nums[i]){
            i--;
        }
        if(i>=j){
      return (i-j+1);
        }else{
            return 0;
        }
    }
}