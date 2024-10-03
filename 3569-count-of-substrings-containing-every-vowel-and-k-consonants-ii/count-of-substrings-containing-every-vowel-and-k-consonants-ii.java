class Solution {
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
    
    public long solve(String word, int k){
        int n = word.length();
        int left = 0, consonantCount = 0;
        long result = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int right = 0; 
        
        while(right < word.length()){
          if(word.charAt(right)=='a' || word.charAt(right)=='e' || word.charAt(right)=='o' || 
          word.charAt(right)=='i' || word.charAt(right)=='u'){
            hm.put(word.charAt(right), hm.getOrDefault(word.charAt(right),0)+1);
          }else{
            consonantCount++;
          }
          while(hm.size()==5 && consonantCount>=k){
            result += word.length()-right;
            if(hm.containsKey(word.charAt(left))){
                int g = hm.get(word.charAt(left));
                if(g==1){
                    hm.remove(word.charAt(left));
                }else{
                    hm.put(word.charAt(left),g-1);
                }
            }else{
                consonantCount--;
            }
            left++;
          }
          right++;

        }

        return result;
            
    }

    public long countOfSubstrings(String word, int k) {
         return solve(word,k) - solve(word,k+1);
    }
}