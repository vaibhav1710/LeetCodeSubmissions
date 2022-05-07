class Solution {
    public boolean find132pattern(int[] nums) {
       
        int min[] = new int[nums.length];
        int n = nums.length;
        min[0] = nums[0];
        for(int i=1;i<n;i++){
            min[i] = Math.min(min[i-1],nums[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        st.push(nums[nums.length-1]);
        for(int i = n-2;i>0;i--){
            
            if(nums[i]>min[i]){
                while(st.size()>0 && st.peek()<=min[i]){
                    st.pop();
                }
                
                if(st.size()>0 && st.peek()<nums[i]){
                    return true;
                }else{
                    st.push(nums[i]);
                }            
            }else{
                st.push(nums[i]);
            }
            
        }
        return false;
    }
}