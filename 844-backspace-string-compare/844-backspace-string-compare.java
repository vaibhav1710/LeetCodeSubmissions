class Solution {
    public boolean backspaceCompare(String s, String t) {
       Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(st.size()>0){
                    st.pop();
                }
            }else{
                st.push(s.charAt(i));
            }
        }
        
        s = "";
        while(st.size()>0){
            s = st.peek() + s;
            st.pop();
        }
        
          for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(st.size()>0){
                    st.pop();
                }
            }else{
                st.push(t.charAt(i));
            }
        }
        
        t = "";
        while(st.size()>0){
            t = st.peek() + t;
            st.pop();
        }
        
        return s.equals(t);
        
    }
}