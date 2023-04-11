class Solution {
    int dp[][];
    boolean vis[];
    ArrayList<Integer> al[];
    int n;
    int vis1[];
    int ans=0;
    public int largestPathValue(String colors, int[][] edges) {
          n = colors.length();
          int max = 0;
          for(int i=0;i<colors.length();i++){
            max = Math.max(max,colors.charAt(i)-'a');
          }
          dp = new int[colors.length()][26];
          al = new ArrayList[colors.length()]; 
          vis = new boolean[colors.length()];
          for(int i=0;i<n;i++){
              al[i] = new ArrayList<>();
          }
          for(int i=0;i<edges.length;i++){
              al[edges[i][0]].add(edges[i][1]);
          }
          vis1 = new int[n];
          for(int i=0;i<n;i++){
              if(vis1[i]==0 && cycle(i)){
                  return -1;
              }
          }
          for(int i=0;i<n;i++){
              if(!vis[i]) dfs(i,colors);
          } 
          return ans;    
    }
    public void dfs(int node,String colors){

           vis[node]=true;
          
           for(int a:al[node]){
               if(!vis[a])
               dfs(a,colors);
           }
           for(int a:al[node]){
               for(int j=0;j<26;j++){
                   dp[node][j] = Math.max(dp[a][j],dp[node][j]);
                   ans = Math.max(ans,dp[node][j]);
               }
           }

           dp[node][colors.charAt(node)-'a']++;
           ans = Math.max(ans,dp[node][colors.charAt(node)-'a']);

    }

   public boolean cycle(int node){
       vis1[node] = 1;
       for(int v:al[node]){
           if(vis1[v]==0){
               if(cycle(v)) return true;
           }else if(vis1[v]==1){
               return true;
           }
       }
       vis1[node]=2;
       return false;
   }

}