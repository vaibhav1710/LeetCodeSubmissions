class Solution {
    public boolean backspaceCompare(String s, String t) {
        String ss="";
        String st= "";
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!='#'){
                if(count==0){
                ss = s.charAt(i)+ss;
                }else{
                    count--;
                }
            }else{
                count++;
            }
        }
        count=0;
        for(int i=t.length()-1;i>=0;i--){
             if(t.charAt(i)!='#'){
                if(count==0){
                st = t.charAt(i)+st;
                }else{
                    count--;
                }
            }else{
                count++;
            }
        }
        
        if(st.equals(ss)){
            return true;
        }else{
            return false;
        }
    }
}