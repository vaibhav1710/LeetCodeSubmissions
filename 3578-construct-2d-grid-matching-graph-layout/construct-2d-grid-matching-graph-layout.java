class Solution {
    private List<Integer> al[];
    private int dp[];
    public int[][] constructGridLayout(int n, int[][] edges) {
        al = new ArrayList[n];
        for(int i=0;i<n;i++) al[i] = new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            int v = edges[i][0];
            int u = edges[i][1];
            al[u].add(v);
            al[v].add(u);
        }
       
       int degrees[] = new int[n];
       boolean one = false;

       for(int i=0;i<n;i++){
        degrees[i] = al[i].size();
        if(degrees[i]==1) one = true;
       }

       if(one){
          
          int src = -1;
          int dest = -1;
          for(int i=0;i<n;i++){
            if(degrees[i]==1){
                if(src==-1) src = i;
                else if(dest==-1) dest = i;
            }
          }
          List<Integer> path = findShortestPath(src,dest);

          int grid[][] = new int[1][path.size()];
          grid[0][0] = src;
          for(int i=0;i<grid[0].length;i++){
            grid[0][i] = path.get(i);
          }
          
          return grid;

       }else{
             
           int cor = -1;
           HashSet<Integer> h = new HashSet<>();
           for(int i=0;i<n;i++){

            if(degrees[i]==2 && cor==-1) {
                cor= i;
           } 
            
            if(degrees[i]==2) {
                h.add(i);
            }    
           
           }
          
          dp = new int[n];
          Arrays.fill(dp,1000000000);
          dp[cor] = 0;
          dij(cor);
         
          int min = n+5;
          int scor = -1;
          for(int v:h){
            // System.out.println(dp[v]); 
            if(dp[v]!=0){
              if(dp[v]<min){
                scor = v;
                min = dp[v];
              }
            }
          }
           //System.out.println(min+1);
           int col = min+1;
           int row = n/(col);

          int grid[][]  = new int[row][col];
          for(int i=0;i<row;i++){
            Arrays.fill(grid[i],-1);
          }
          grid[0][0] = cor;
          grid[0][col-1] = scor;

         List<Integer> path = findShortestPath(cor, scor);
         
         for(int i=1;i<path.size();i++){
             grid[0][i] = path.get(i);
            // System.out.print(path.get(i)+" -> ");
         }

         for(int r=1;r<row;r++){
           
           for(int c=0;c<col;c++){
             
             int node = grid[r-1][c];
            // System.out.print(node+" - ");
             HashSet<Integer> hs = new HashSet<>();
             for(int v:al[node]) hs.add(v);
             
             if(c==0){
               hs.remove(grid[r-1][c+1]);
               if(r>=2) hs.remove(grid[r-2][c]);
               for(int z:hs) grid[r][c] = z;  
             }else if(c==grid[0].length-1){
               hs.remove(grid[r-1][c-1]);
               if(r>=2) hs.remove(grid[r-2][c]);
               for(int z:hs) grid[r][c] = z;
             }else{
                hs.remove(grid[r-1][c+1]);
                hs.remove(grid[r-1][c-1]);
                if(r>=2) hs.remove(grid[r-2][c]);
                for(int z:hs) grid[r][c] = z;
             }
               
           }
           //System.out.println();
         }
            return grid;
       }

         
    }

    private void dij (int source){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        pq.add(new int[]{source,0});

        while(pq.size()>0){
              
              int rem[] = pq.remove();

              for(int v:al[rem[0]]){
                if(dp[v] > dp[rem[0]] + 1){
                    dp[v] = dp[rem[0]] + 1;
                    pq.add(new int[]{v,dp[v]});
                }
              }              
        }
    }

    public  List<Integer> findShortestPath(int source, int dest) {
        // To store the parent of each node to reconstruct the path
        int[] parent = new int[al.length];
        Arrays.fill(parent, -1); // Initialize parent array with -1 (unvisited nodes)
        
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        
        // Visited array to track visited nodes
        boolean[] visited = new boolean[al.length];
        visited[source] = true;

        // BFS loop
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // If destination is reached, break the loop
            if (current == dest) break;

            // Explore neighbors
            for (int neighbor : al[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current; // Track the parent for path reconstruction
                    queue.add(neighbor);
                }
            }
        }

        // If destination is not reached
        if (!visited[dest]) {
            return Collections.emptyList(); // Return empty list if no path found
        }

        // Reconstruct the path from dest to source
        List<Integer> path = new ArrayList<>();
        for (int at = dest; at != -1; at = parent[at]) {
            path.add(at);
        }
        // Reverse the path to get it from source to dest
        Collections.reverse(path);
        
        return path;
    }
}