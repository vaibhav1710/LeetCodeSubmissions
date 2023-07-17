class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
       
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
               
                if (map.get(c) == 0) {
                    count++;
                }
            }
           r++;
            
            while (count == map.size()) {
                
                if (r - l < minLen) {
                    minLen = r - l;
                    ans = s.substring(l,r);
                }
                char d = s.charAt(l); 
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                   
                    if (map.get(d) > 0) {
                        count--;
                    }
                }
                l++;
            }
        }
        
        
        return minLen == Integer.MAX_VALUE ? "" : ans;
    }
}