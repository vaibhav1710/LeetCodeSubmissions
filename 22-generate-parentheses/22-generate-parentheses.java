class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
           ans = new ArrayList<>();
           String tn = "";
           solve(n,n,"");
           return ans;
        }
    
    public void solve(int open,int close,String s){
       
        if(close<open){
            return;
        }   
        if(open<0){
            return;
        }
        if(open == 0 && close==0){
            ans.add(s);
            return;
        }
        
        solve(open-1,close,s+"(");
        solve(open,close-1,s+")" );
        
        return;
    }
}