class Solution {
    private  ArrayList<Integer> al[];
    private  int dp[][];
    private int ans[];
    public int[] timeTaken(int[][] edges) {
        int nodes = edges.length+1;
        al = new ArrayList[edges.length+1];
        for(int i=0;i<nodes;i++) al[i] = new ArrayList<>();

        for(int i=0;i<nodes-1;i++){
            int v = edges[i][0];
            int u = edges[i][1];
            al[u].add(v);
            al[v].add(u);
        }
        
        dp = new int[nodes][2];
        
        dfs(0,-1);
        ans = new int[nodes];
        ans[0] = dp[0][0];
        dfs1(0,-1);

        return ans;
    }

    private void dfs1(int c, int p){
        int m = dp[c][0];
        int n = dp[c][1];

        for(int v:al[c]){
            if(v==p) continue;
            
            int vdis = dp[v][0]+1;
            if(v%2==0) vdis++;

            int unknow = dp[c][0];
            if(vdis == dp[c][0]){
               unknow = dp[c][1];
            }

            if(c%2==0) unknow +=2;
            else unknow += 1;

            if(unknow >= dp[v][0]){
                dp[v][1] = dp[v][0];
                dp[v][0] = unknow;
            }else if(unknow >= dp[v][1]){
                dp[v][1] = unknow;
            }

            ans[v] = dp[v][0];

            dfs1(v,c);             
        }
    }


    private void dfs(int c, int p){
        int max = 0;
        int smax = 0;
      
        for(int v:al[c]){
            if(v!=p){
                dfs(v,c);
                int time = dp[v][0];
                time += (v%2==0)?2:1;

                if(time>=max){
                    smax = max;
                    max = time;
                }else if(time >= smax){
                    smax = time;
                }
            }
        }

        dp[c][0] = max;
        dp[c][1] = smax;
    }
}