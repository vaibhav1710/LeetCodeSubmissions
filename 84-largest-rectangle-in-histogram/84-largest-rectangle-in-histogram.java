class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int sr[] = next_smallest_on_right(heights);
        int sl[] = next_smallest_on_left(heights);
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<heights.length;i++){
            
            max = Math.max(max , (sr[i]-i)*heights[i] + (i-sl[i])*heights[i] - heights[i]);
            
        }
        
        return max;
        
    }
    
    public int [] next_smallest_on_right(int [] h){
        
        int a[] = new int[h.length];
        Stack<Integer> st = new Stack<>();
        a[h.length-1] = h.length;
        st.add(h.length-1);
        
        for(int i = h.length-2;i>=0;i--){
            
            while(st.size()>0 && h[i]<=h[st.peek()]){
                st.pop();
            }
            
            if(st.size()==0){
                a[i] = h.length;
            }else{
                a[i] = st.peek();
            }
            st.push(i);
            
        }
        
        return a;
        
    }
    
    public int [] next_smallest_on_left(int [] h){
        
        int a[] = new int[h.length];
        Stack<Integer> st = new Stack<>();
        a[0] = -1;
        st.add(0);
        
        for(int i = 1;i<h.length;i++){
            
            while(st.size()>0 && h[i]<=h[st.peek()]){
                st.pop();
            }
            
            if(st.size()==0){
                a[i] =-1;
            }else{
                a[i] = st.peek();
            }
            st.push(i);
            
        }
        
        return a;
        
    }
}