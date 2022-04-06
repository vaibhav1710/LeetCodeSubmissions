class Solution {
    public boolean validPalindrome(String s) {
        
        if(s.length()==1){
            return true;
        }
        
        boolean flag = false;
        boolean pal = true;
        int i=0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                if(!flag){
                    flag = true;
               boolean ch = check(i,j,s);
                  return ch;
                }else{
                    pal = false;
                   return false;
                }
            }
        }
        return true;
       
    }
    
    public boolean check(int i,int j,String s){
        int ti = i;
        int tj = j;
        ti++;
        boolean f = true;
        while(ti<tj){
            if(s.charAt(ti)==s.charAt(tj)){
                ti++;
                tj--;
                continue;
            }else{
                f = false;
                break;
            }
        }
        
        if(!f){
            f = true;
            ti = i;
            tj = j;
            tj--;
             while(ti<tj){
            if(s.charAt(ti)==s.charAt(tj)){
                ti++;
                tj--;
                continue;
            }else{
                f = false;
                break;
            }
        }
            
        }
        if(f){
            return true;
        }else{
            return false;
        }
        
    }
}