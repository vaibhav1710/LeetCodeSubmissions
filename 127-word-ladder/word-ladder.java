class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        
        HashSet<String> h = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
        
            if(!wordList.get(i).equals(beginWord))
            h.add(wordList.get(i));
        
        }
        
        while(q.size()>0){
            
            Pair rm = q.remove(); 
            String s = rm.s;
            int tp = rm.tp;
            
            if(s.equals(endWord)) return tp;
            
            for(int i=0;i<s.length();i++){
                // hr indx ko a-z se chnge krke dek
                for(char j='a';j<='z';j++){
                    char cc[] = s.toCharArray();
                    cc[i] = j;
                    String cs  = new String(cc);

                    if (h.contains(cs)) {
                        h.remove(cs);
                        q.add(new Pair(cs, tp + 1));
                    }
                }
            }
            
        }
        return 0;
    }
    
    class Pair{
        String s;
        int tp;
        Pair(String s, int tp){
            this.s=s;
            this.tp=tp;
        }
    }
}