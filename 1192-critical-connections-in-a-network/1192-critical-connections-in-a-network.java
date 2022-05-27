class Solution {
    
    public List<List<Integer>> res;
    public ArrayList<Integer> graph[];
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        res = new ArrayList<>();
        graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<connections.size();i++){
            List<Integer> tmp = connections.get(i);
            graph[tmp.get(0)].add(tmp.get(1));
            graph[tmp.get(1)].add(tmp.get(0));
        }
        
        answer(n);
        
        return res;
    }
    
    public void answer(int n){
        
        int low[] = new int[n]; 
        int tin[] = new int[n];
        int vis[] = new int[n];
        int timer =1;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,-1,low,tin,vis, timer);
            }
        }
    }
    
public void dfs(int node,int parent , int [] low , int [] tin,int []vis ,int timer){
        
        vis[node] = 1;
        low[node] = tin[node] = timer++;
        
        for(int nbr : graph[node]){
            
            if(nbr==parent) continue; 
            if(vis[nbr]==0){
                dfs(nbr,node,low,tin,vis,timer);
                low[node] = Math.min(low[node],low[nbr]);
                
                if(low[nbr] > tin[node]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nbr);
                    temp.add(node);
                    res.add(temp);
                }
            }else{
                low[node] = Math.min(low[node],tin[nbr]);
            }
        }
        
        
    }
    
}