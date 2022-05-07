class Solution {
    public boolean find132pattern(int[] nums) {
        
        // can1 < can2 > can3
        // can3 > can1
        
        int min[] = new int[nums.length];
        int n = nums.length;
        min[0] = nums[0];
        // storing min for each index (which will be our can1)
        for(int i=1;i<n;i++){
            min[i] = Math.min(min[i-1],nums[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        st.push(nums[nums.length-1]);
        for(int i = n-2;i>0;i--){
            
            // nums[i] is our can2
            // st.peek() will be our can3
            if(nums[i]>min[i]){  // can2 > can2
                 // can3 > can1
                
                // removing all peek which are less than can1
                while(st.size()>0 && st.peek()<=min[i]){
                    st.pop();
                }
             
                // since can1 < can3
                // Now for answer to exist can3 < can2
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