class Solution {
    public int longestStrChain(String[] words) {
        
       Arrays.sort(words, (a,b)-> a.length() - b.length());
       int maxi = 1;
        int lis[] = new int[words.length];
        
        for(int i=0;i<words.length;i++){
             int max = 0;
            for(int j=0;j<i;j++){
              
                if(chain(words[j],words[i]) && (lis[j]+1>lis[i])){
                    max  = Math.max(max,lis[j]);
                }
                 
            }
            
            lis[i] = max+1;
            maxi = Math.max(maxi,lis[i]);
        }
        
        return maxi;
    }
    
private boolean chain(String s1, String s2){
        if(s1.length() != s2.length() - 1) return false;  // bda && bdca
        
        int first = 0;  // bda pointer
        int second = 0; // bdca pointer
        
       while(second < s2.length()){
            if(first < s1.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else second++;
        }
        
        if(first == s1.length() && second == s2.length()) return true;
        
        else return false;
    }
   
}


 
