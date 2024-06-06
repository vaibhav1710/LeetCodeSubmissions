class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        Arrays.sort(hand);
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<hand.length;i++){
            hm.put(hand[i],hm.getOrDefault(hand[i],0)+1);
        }
        
        int ind = 0;
        int n = hand.length;
        
        if(n%groupSize!=0) return false;
        
        
        while(ind<n){
          
            int f = hand[ind];
            
            if(hm.get(f)>0){    
                for(int i=0;i<groupSize;i++){   
                    if(!hm.containsKey(f) || hm.get(f)==0){
                        return false;
                    }else{
                        hm.put(f, hm.get(f)-1);
                    }
                    f++;
                }
            }
            ind++;
        }
        
     return true;
    }
}