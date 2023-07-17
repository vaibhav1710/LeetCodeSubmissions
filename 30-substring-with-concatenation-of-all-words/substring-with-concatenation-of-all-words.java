class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int len1 = words.length*words[0].length();
        for(int i=0;i<words.length;i++){
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }
        int len = words[0].length();
        int num = words.length;
        for(int i=0;i<= s.length() - (len*num); i++){
          if(check(hm, s, i , len1 , len, words.length)){
              ans.add(i);
          }
        }
        return ans;
    }

    public boolean check(HashMap<String,Integer> hm, String s, int sp ,int tot ,int len,int k){
       

       HashMap<String,Integer> curr = new HashMap<>();
       for(int i=0;i<k;i++){
           String tmp = s.substring(sp + i*len,sp+(i+1)*len);
           int v = hm.getOrDefault(tmp,-1);
           if(v==-1) return false;
           int v1 = curr.getOrDefault(tmp,0);
           if(v1>=v) return false;
           curr.put(tmp,v1+1);
       }
return true;
    }
}