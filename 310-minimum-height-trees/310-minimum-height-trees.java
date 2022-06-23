class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n==1){
          ans.add(0);
            return ans;
        }
        int deg[] = new int[n];
        ArrayList<Integer> al[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            al[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            deg[edges[i][0]]++;
            deg[edges[i][1]]++;
            al[edges[i][0]].add(edges[i][1]);
            al[edges[i][1]].add(edges[i][0]);
        }
        boolean vis[] = new boolean[n];
        Queue<Integer> q  = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(deg[i]==1){
                vis[i] = true;
                q.add(i);
            }
        }
        
        while(q.size()!=0){
            ans = new ArrayList<>();
            int s = q.size();
            while(s-->0){
                int r = q.remove();
                vis[r] = true;
                ans.add(r);
                for(int nbr:al[r]){
                    if(!vis[nbr]){
                       deg[nbr]--;
                        if(deg[nbr]==1){
                            vis[nbr] = true;
                            q.add(nbr);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}