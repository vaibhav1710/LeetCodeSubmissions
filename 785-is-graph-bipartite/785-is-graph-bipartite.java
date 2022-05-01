class Solution {
    public boolean isBipartite(int[][] graph) {
        
        boolean[] vis = new boolean[graph.length];
        int ans[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
               boolean f = bfs(i,vis,graph,ans);
                if(!f){
                 return false;   
                }
            }
        }
        
        return true;
        
    }
    
    public  boolean bfs(int i , boolean [] vis , int [][] graph,int [] ans){
        
        vis[i] = true;
        ans[i] = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        int v=1;
        while(q.size()>0){
            
            int s = q.size();
            v *= -1;
            while(s-->0){
                
                int r = q.remove();
                for(int z:graph[r]){
                    
                     if(!vis[z]){
                        q.add(z);
                         vis[z] = true;
                    }
                    
                    if(ans[z]==0){
                        ans[z] = v;
                    }else if(ans[z]==v){
                        continue;
                    }else{
                        return false;
                    }
                    
                }
            }
            
            
        }
        return true;
    }
    
}