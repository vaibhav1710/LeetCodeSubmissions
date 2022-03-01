class Solution {
    public int shortestPathLength(int[][] graph) {
        
        Queue<int []> q = new LinkedList<>();
        HashSet<String> h = new HashSet<>();
        int tar = 1<<graph.length  ;
        tar -= 1;
        for(int i=0;i<graph.length;i++){
            q.add(new int[]{i,0,1<<i});
            h.add(i+""+(1<<i));
        }
        
        while(q.size()>0){
            int s = q.size();
            while(s-->0){
                
                int r[] = q.remove();
                if(r[2]==tar){
                    return r[1];
                }else{
                    for(int nbr:graph[r[0]]){
                        int newmask = r[2] | (1<<nbr);
                        if(h.contains(nbr +""+(newmask))){
                            continue;
                        }else{
                            q.add(new int[] {nbr,r[1]+1,newmask});
                            h.add(nbr+""+(newmask));
                        }
                        
                    }
                    
                }
                
            }
        }
        return -1;
    }
}