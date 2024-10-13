class Solution {
    private int[][] dp;
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int n = source.length();
        int m = pattern.length();
        dp = new int[n][m+1];
        boolean[] boolarr = new boolean[n];

        for(int num : targetIndices){
            boolarr[num] = true;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = -1;
            }
        }

        int ans = recursion(source, pattern, n, m, 0, 0, boolarr);
        return targetIndices.length - (ans == Integer.MAX_VALUE ? 0 : ans);
    }

    public int recursion(String s, String p, int n, int m,int i, int j, boolean arr[]){
        if(j==m) return 0;
        if(i==n) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int dontake = recursion(s,p,n,m,i+1,j,arr);
        int take = Integer.MAX_VALUE;

        if(s.charAt(i)==p.charAt(j)){
            take = recursion(s,p,n,m,i+1,j+1,arr);
            int add=0;
            if(arr[i]) add++;
            if(take!=Integer.MAX_VALUE){
                take = take + add;
            }
        }

        return dp[i][j] = Math.min(take,dontake);


    }
}