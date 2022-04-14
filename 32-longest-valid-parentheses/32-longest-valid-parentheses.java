class Solution {
   
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        if(s.length()==0){
            return 0;
        }else if(s.length()==1){
            return 0;
        }
        st.push(-1);
        st.push(0);
        int count = 0;
        int max = 0;
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                if(st.size()>1 && s.charAt(st.peek())=='('){
                    st.pop();
                    count = i - st.peek();
                    max = Math.max(count,max);
                    
                }else {
                    
                    st.push(i);
                    
                }
            }
        }
        
        return max;
        
             
        }
    }
