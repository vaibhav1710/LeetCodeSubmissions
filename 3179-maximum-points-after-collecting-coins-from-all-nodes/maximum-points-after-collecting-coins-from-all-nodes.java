class Solution {
    List<Integer> al[];
    int dp[][];
    public int maximumPoints(int[][] edges, int[] coins, int k) {
         al = new ArrayList[coins.length];
         int n = coins.length;

         dp = new int[n][20];
         for(int i=0;i<n;i++){
             al[i] = new ArrayList<>();
            Arrays.fill(dp[i],-1);
         }
         
         for(int a[]:edges){
            int v = a[0];
            int u = a[1];
            al[v].add(u);
            al[u].add(v);
         }

         return solve(0,-1,0,k,coins);

    }

    public int solve(int c, int p, int siu, int k, int coins[]){
         
        if(siu > 19) return Integer.MIN_VALUE; 

        int cc = coins[c];

        if(dp[c][siu]!=-1) return dp[c][siu];

        int cck = cc >> siu;

        int a = cck/2; // mei bhi 2nd se hi lelu

        for(int v:al[c]){
            if(v!=p){
                a += solve(v,c,siu+1,k,coins);
            }
        }

        int b = cck-k; // mei first se lelu

        for(int v:al[c]){
            if(v!=p){
                b += solve(v,c,siu,k,coins);
            }
        }

        dp[c][siu] = Math.max(a,b);
        return dp[c][siu];
    }
}