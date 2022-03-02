class Solution {
    public boolean isSubsequence(String s, String t) {
       
        int pointert=0;
        int pointers=0;
        
       while(pointert<t.length()){
           
           if(pointers==s.length()){
               return true;
           }
           
           if(s.charAt(pointers)==t.charAt(pointert)){
               pointert++;
               pointers++;
           }else{
                pointert++; 
           }
           
           
       }
        if(pointert==t.length() && pointers==s.length()){
        return true;
    }
        return false;
}
}