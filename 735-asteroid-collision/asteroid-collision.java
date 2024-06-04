class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /*
         
         2 4 -2 1 -3 -2 5 7 -1
         2  4 -2 5 7      
         - last mei same dir wale hi bachenge (agr bache toh)
         - ? o
            */
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<asteroids.length;i++){
            while(st.size()>0 && asteroids[i]<0 && asteroids[st.peek()]>0){
                int diff = asteroids[i] + asteroids[st.peek()];
                if(diff>0){
                    asteroids[i]=0;
                }else if(diff<0){
                    st.pop();
                }else{
                    asteroids[i]=0;
                    st.pop();
                }
            }
            
            if(asteroids[i]!=0){
                st.add(i);
            }
        }
        int ans[] = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = asteroids[st.pop()];
        }
        return ans;
        
    }
}