class Solution {
    public String longestPalindrome(String s) {
        HashMap<Character,ArrayList<Integer>> h = new HashMap<>();
        int dp[] = new int[s.length()];
        int omax = Integer.MIN_VALUE;
        int l=0;
        int r=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!h.containsKey(c)){
                dp[i]=1;
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                if(dp[i]>omax){
                    l=i;
                    r=i;
                }
                h.put(c,al);
            }else{
                ArrayList<Integer> al = h.get(c);
                al.add(i);
                for(int j=0;j<al.size();j++){
                    if(pal(al.get(j),i,s)){
                        dp[i] = i-al.get(j)+1;
                        if(dp[i]>omax){
                            l = al.get(j);
                            r = i;
                            omax = dp[i];
                        }
                        break;
                    }else{
                        continue;
                    }
                }
            h.put(c,al);
            }
        }
        
        return s.substring(l,r+1);
        
    }
    
    public  boolean pal(int i,int j,String s){
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}