class Solution {
    private ArrayList<Integer> al[];
    private int dp[][];
    private int ans;
    public int longestPath(int[] parent, String s) {
        int n = s.length();
        al = new ArrayList[n];

        for(int i=0;i<n;i++) al[i] = new ArrayList<>();

        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1) continue;
            else{
                al[parent[i]].add(i);
                al[i].add(parent[i]);
            }
        }
        
        

        dp = new int[n][2];
        ans = 0;
        dfs(0,-1,s);
        ans = dp[0][0];
        dfs1(0,-1,s);
        return ans;
    }

    private void dfs1(int c, int p, String s){
        int a = dp[c][0];
        int b = dp[c][1];

        for(int v:al[c]){
            if(v==p) continue;
            int v_max = dp[v][0];
            int c_max = dp[c][0];

            if(s.charAt(v)!=s.charAt(c)){
                v_max++;
            }

            if(v_max == c_max){
               c_max = dp[c][1];
            }

            if(s.charAt(v)!=s.charAt(c)){
                c_max++;
                if(dp[v][0]<=c_max){
                    dp[v][1] = dp[v][0];
                    dp[v][0] = c_max;
                }
            }
            ans = Math.max(ans, dp[v][0]);
            dfs1(v,c,s);
        }

    }

    private void dfs(int c, int p, String s){
         
      int max = 0;
      int smax = 0;
      
      for(int v:al[c]){
        
        if(v==p) continue;
        dfs(v,c,s);
        int dis = dp[v][0];
        
        if(s.charAt(c)==s.charAt(v)){
            
        }else{
            
            if(dis>=max){
                smax = max;
                max = dis;
            }else if(dis>=smax){
                smax = dis;
            }
        }
       
      }

      dp[c][0] = max+1;
      dp[c][1] = smax+1;
    }
}