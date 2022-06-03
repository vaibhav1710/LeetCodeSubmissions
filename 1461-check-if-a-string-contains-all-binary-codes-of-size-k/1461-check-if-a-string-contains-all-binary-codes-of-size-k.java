class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> h = new HashSet<>();
        
        for(int i=0;i<=s.length()-k;i++){
            h.add(s.substring(i,i+k));
        }
        
        
        return h.size() == Math.pow(2,k);
    }
}