class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> h = new HashMap<>();
        int ans = 0;
        int start = 0;
        int end=0;
        for(int i=0;i<s.length();i++){
            if(!h.containsKey(s.charAt(i))){
                h.put(s.charAt(i),i);
                ans = Math.max(ans,i-start+1);
            }else{
                ans = Math.max(ans,i-start);
                end = h.get(s.charAt(i));
                for(int j=start;j<=end;j++){
                    if(h.containsKey(s.charAt(j))){
                        h.remove(s.charAt(j));
                    }
                }
                start = end+1;
                h.put(s.charAt(i),i);
                ans = Math.max(ans,i-start+1);
            }
        }
        
        return ans;
    }
}