class Solution {
    ArrayList<Integer> al[] ;
    public int magnificentSets(int n, int[][] edges) {
        al = new ArrayList[n];
        for(int i=0;i<n;i++){
            al[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            al[edges[i][0]-1].add(edges[i][1]-1);
            al[edges[i][1]-1].add(edges[i][0]-1);
        }

        List<List<Integer>> comp =  components(al,n);
        int ans = 0;
        for(List<Integer> c:comp){
            int g = -1;
            for(int v:c){
                int level = bfs(v);
                g = Math.max(level,g);
            }
            if(g==-1){
                return -1;
            }
            ans += g;
        } 
       return ans;
    }

    private int bfs(int node){
        int levl=1;
        Queue<int[]> q = new LinkedList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(node,1);
        q.add(new int[]{node,1});
        while(q.size()!=0){
            int a[] = q.remove();
            levl = Math.max(levl,a[1]);
            for(int v:al[a[0]]){
                if(!hm.containsKey(v)){
                    q.add(new int[]{v,a[1]+1});
                    hm.put(v,a[1]+1);
                }else if(hm.containsKey(v) && hm.get(v)==a[1]){
                    return -1;
                }
            }
        }
        return levl;
    }

    public List<List<Integer>> components(ArrayList<Integer> g[],int n){
        List<List<Integer>> res = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!vis[i]){
                List<Integer> an = dfs(i,vis,new ArrayList<>());
                vis[i]=true;
                res.add(an);
            }
        }
        return res;
    }

    public List<Integer> dfs(int node, boolean vis[],List<Integer> an){
        vis[node]=true;
        an.add(node);
        for(int v:al[node]){
            if(!vis[v]){
                dfs(v,vis,an);
            }
        }
        return an;
    }
}