class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int nge[] = new int[nums.length];
        int n = nums.length;
        nge[n-1]=n;
        Stack<Integer> st = new Stack<>();
        
        st.add(n-1);
        
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i] = nums.length;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        
        int ans[] = new int[n-k+1];
        
        for(int i=0;i<n-k+1;i++){
            
            int j = i;
            while(nge[j] < i+k){
                j = nge[j];
            }
            ans[i] = nums[j];
        }
        return ans;
    }
}