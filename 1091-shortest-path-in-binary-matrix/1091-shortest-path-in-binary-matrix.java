class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,1));
     //   vis[0][0] = true;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        vis[0][0] = true;
     //   int dx [] = {0,1,1,1,0,-1,-1,-1};
       // int dy[] = {1,1,0,-1,-1,-1,0,1};
        
         int[] dx = {0, 1, -1, 0, 1, -1, 1, -1};
        int[] dy = {1, 0, 0, -1, 1, -1, -1, 1};
        while(pq.size()>0){
            int s = pq.size();
            while(s-->0){
            Pair r = pq.remove();
           
            if(r.x == grid.length-1 && r.y == grid[0].length-1){
                return r.dis;
            }
            for(int i=0;i<8;i++){
                int nx = r.x + dx[i];
                int ny = r.y + dy[i];
if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && !vis[nx][ny] && grid[nx][ny]==0){
                    pq.add(new Pair(nx,ny,r.dis+1));
                    vis[nx][ny] = true;
                }
            }
            }
        }
        
        return -1;
         
    }
    
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int dis;
        Pair(int x,int y,int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
        public int compareTo(Pair o){
            return this.dis - o.dis;
        }
    }
}