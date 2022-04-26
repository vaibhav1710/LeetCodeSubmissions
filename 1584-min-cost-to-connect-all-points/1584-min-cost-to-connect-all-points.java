// #MST

class Solution {
    public int minCostConnectPoints(int[][] points) {
     
        ArrayList<Pair> [] al = new ArrayList[points.length];
        for(int i=0;i<points.length;i++){
            al[i] = new ArrayList<>();
        }
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
    al[i].add(new Pair(j,Math.abs(points[i][0]-points[j][0]) + Math.abs(points[j][1] - points[i][1])));
                 al[j].add(new Pair(i,Math.abs(points[i][0]-points[j][0]) + Math.abs(points[j][1] - points[i][1])));
            }
        }
        
      int ans =  bfs(al , points);
        return ans;
        
    }
    
    public int bfs( ArrayList<Pair> [] al,int[][] points){
        int ans=0;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0));
        boolean vis [] = new boolean[points.length];
       int edge=0;
        
        while(q.size()>0 && edge!=points.length){
            
            Pair r = q.remove();
            if(vis[r.x]){
                continue;
            }else{
            for(Pair a:al[r.x]){
                q.add(a);
            }
             vis[r.x] = true;
             ans += r.wt;
                edge++;
            }    
        }
        return ans;
    }
    
    class Pair implements Comparable<Pair>{
        int x;
        int wt;
        Pair(int x,int wt){
            this.x= x;
            this.wt = wt;
        }
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
    }
    
}