class Solution {
    public int removePalindromeSub(String s) {
        
        boolean pal = true;
        int i=0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                pal = false;
                break;
            }
        }
        
        if(pal) return 1;
        else return 2;
    }
}