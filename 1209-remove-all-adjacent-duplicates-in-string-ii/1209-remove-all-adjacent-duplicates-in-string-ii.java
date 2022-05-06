class Solution {
    public String removeDuplicates(String s, int k) {
       
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.size()>0 && st.peek().c == s.charAt(i)){
                st.peek().count++;
            }else{
                st.push(new Pair(s.charAt(i),1));
            }
            
            if(st.peek().count==k){
                st.pop();
            }
        }
        
       StringBuilder sb = new StringBuilder();
        for(Pair r:st){
            for(int i=0;i<r.count;i++){
            sb.append(r.c);
            }
        }
       return sb.toString();

        
    }
    class Pair{
        char c;
        int count;
        Pair(char c,int count){
            this.c=c;
            this.count=count;
        }
    }
    
}